package fitness.domain.dto;

import fitness.domain.dto.types.*;
import fitness.domain.utils.ProductLineOperation;
import fitness.domain.utils.ProductLineOperations;
import fitness.service.utils.ValidationConstants;

import javax.validation.constraints.NotNull;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public class ProductLineDTO {

    private Long id;
    @NotNull
    private ProductDTO product;
    @NotNull(message = ValidationConstants.PRODUCT_LINE_VALUE_REQUIRED)
    private Integer value;

    public ProductLineDTO(Long id, ProductDTO product, Integer value) {
        this.id = id;
        this.product = product;
        this.value = value;
    }

    public ProductLineDTO() {
    }

    public Long getId() {
        return id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public Integer getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Protein getProtein() {
        return Protein.of(product.getMeasure().apply(product.getProtein().toInteger(), getValue()));
    }
    public Calories getCalories() {
        return Calories.of(product.getMeasure().apply(product.getCalories().toInteger(), getValue()));
    }
    public Fat getFat() {
        return Fat.of(product.getMeasure().apply(product.getFat().toInteger(), getValue()));
    }
    public Carbohydrate getCarbohydrate() {
        return Carbohydrate.of(product.getMeasure().apply(product.getCarbohydrate().toInteger(), getValue()));
    }
}
