package fitness.rest.controller;

import fitness.domain.dto.ProductDTO;
import fitness.rest.model.ProductModel;
import fitness.service.business.ProductService;
import fitness.service.validator.ValidationManager;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


/**
 * Created by Anton_Kramarev on 6/19/2017.
 */

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE, value = "/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private DozerBeanMapper mapper;

    @PostMapping
    @ResponseBody
    public ResponseEntity createProduct(@RequestBody ProductModel model) {
        ProductDTO productDTO = mapper.map(model, ProductDTO.class);
        ProductDTO savedProductDTO = productService.createProduct(productDTO);
        ProductModel createdProduct = mapper.map(savedProductDTO, ProductModel.class);
        ControllerLinkBuilder linkBuilder = linkTo(methodOn(ProductController.class).getProduct(createdProduct.getProductId()));
        createdProduct.add(linkBuilder.withSelfRel());
        return ResponseEntity.created(linkBuilder.toUri()).body(createdProduct);
    }

    @GetMapping(value = "/{productId}")
    @ResponseBody
    public ResponseEntity<ProductModel> getProduct(@PathVariable Long productId) {
        ProductDTO product = this.productService.getProduct(productId);
        ProductModel productModel = mapper.map(product, ProductModel.class);
        productModel.add(linkTo(methodOn(ProductController.class).getProduct(productId)).withSelfRel());
        return ResponseEntity.ok(productModel);
    }

    @DeleteMapping(value = "/{productId}")
    @ResponseBody
    public ResponseEntity deleteProduct(@PathVariable Long productId) {
        this.productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<ProductModel>> getProductsByName(@Param("nameStartWith") String nameStartWith, Pageable pageable) {
        Page<ProductDTO> productsByName = this.productService.getProductByName(nameStartWith, pageable);
        Page<ProductModel> productModels = productsByName.map(p -> mapper.map(p, ProductModel.class));
        productModels.forEach(productModel -> productModel.add(linkTo(
                methodOn(ProductController.class).getProduct(productModel.getProductId())).withSelfRel()));
        return ResponseEntity.ok(productModels);
    }

}
