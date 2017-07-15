package fitness.rest.controller;

import fitness.domain.dto.ProductLineDTO;
import fitness.rest.model.ProductLineModel;
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
    private ProductService productService;
    @Autowired
    private DozerBeanMapper mapper;

    @GetMapping(value = "/{productLineId}")
    @ResponseBody
    public ResponseEntity<ProductLineModel> getProductLine(@PathVariable Long productLineId) {
        ProductLineDTO productLineDTO = this.productService.getProductLine(productLineId);
        ProductLineModel model = mapper.map(productLineDTO, ProductLineModel.class);
        model.add(linkTo(methodOn(ProductLineController.class).getProductLine(productLineId)).withSelfRel());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

}
