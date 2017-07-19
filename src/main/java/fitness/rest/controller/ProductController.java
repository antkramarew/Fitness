package fitness.rest.controller;

import fitness.domain.dto.ProductDTO;
import fitness.rest.model.ProductModel;
import fitness.service.business.ProductService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


/**
 * Created by Anton_Kramarev on 6/19/2017.
 */

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE, value = "/api/v1/products")
public class ProductController {

    public static final String MAP_ID = "productToModel";
    @Autowired
    private ProductService productService;
    @Autowired
    private DozerBeanMapper mapper;

    @PostMapping
    @ResponseBody
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel model) {
        ProductDTO productDTO = mapper.map(model, ProductDTO.class, MAP_ID);
        ProductDTO savedProductDTO = productService.createProduct(productDTO);
        ProductModel createdProduct = mapper.map(savedProductDTO, ProductModel.class, MAP_ID);
        createdProduct.add(linkTo(methodOn(ProductController.class).getProduct(createdProduct.getProductId())).withSelfRel());
        return new ResponseEntity(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{productId}")
    @ResponseBody
    public ResponseEntity<ProductModel> getProduct(@PathVariable Long productId) {
        ProductDTO product = this.productService.getProduct(productId);
        ProductModel productModel = mapper.map(product, ProductModel.class, MAP_ID);
        productModel.add(linkTo(methodOn(ProductController.class).getProduct(productId)).withSelfRel());
        return  new ResponseEntity(productModel, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{productId}")
    @ResponseBody
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        this.productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<ProductModel>> getProductsByName(@Param("name") String name, Pageable pageable) {
        Page<ProductDTO> productsByName = this.productService.getProductByName(name, pageable);
        Page<ProductModel> productModels = productsByName.map(p -> mapper.map(p, ProductModel.class, MAP_ID));
        productModels.forEach(productModel -> productModel.add(linkTo(
                methodOn(ProductController.class).getProduct(productModel.getProductId())).withSelfRel()));
        return new ResponseEntity<>(productModels, HttpStatus.OK);
    }

}
