package fitness.rest.controller;

import fitness.domain.dto.ProductLineDTO;
import fitness.rest.model.ProductLineModel;
import fitness.rest.model.ProductLineResponseModel;
import fitness.service.business.ProductLineService;
import fitness.service.business.ProductService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        produces = MediaType.APPLICATION_JSON_VALUE, value = "/api/v1/products/lines")
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;
    @Autowired
    private ProductService productService;
    @Autowired
    private DozerBeanMapper mapper;

    @GetMapping(value = "/{productLineId}")
    @ResponseBody
    public ResponseEntity<ProductLineResponseModel> getProductLine(@PathVariable Long productLineId) {
        ProductLineDTO productLineDTO = this.productLineService.getProductLine(productLineId);
        ProductLineResponseModel model = mapper.map(productLineDTO, ProductLineResponseModel.class);
        model.add(linkTo(methodOn(ProductLineController.class).getProductLine(productLineId)).withSelfRel());
        model.add(linkTo(methodOn(ProductController.class).getProduct(productLineDTO.getProduct().getId())).withRel("product"));
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ProductLineResponseModel> createProductLine(@RequestBody ProductLineModel request) {
        ProductLineDTO line = mapper.map(request, ProductLineDTO.class);
        line.setProduct(productService.getProduct(request.getProductId()));
        ProductLineDTO createdLine = this.productLineService.createProductLine(line);
        ProductLineResponseModel response = mapper.map(createdLine, ProductLineResponseModel.class);
        response.add(linkTo(methodOn(ProductLineController.class).getProductLine(response.getLineId())).withSelfRel());
        response.add(linkTo(methodOn(ProductController.class).getProduct(request.getProductId())).withRel("product"));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
