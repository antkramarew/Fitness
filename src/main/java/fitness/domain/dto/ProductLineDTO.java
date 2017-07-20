package fitness.domain.dto;

import fitness.domain.dto.types.NutritionFacts;
import fitness.domain.utils.ProductLineOperation;
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
    private NutritionFacts totals;

    public ProductLineDTO(Long id, ProductDTO product, Integer value, NutritionFacts totals) {
        this.id = id;
        this.product = product;
        this.value = value;
        this.totals = totals;
    }

    public ProductLineDTO() {
    }

    public ProductLineDTO apply(ProductLineOperation operation) {
        return operation.apply(this);
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

    public NutritionFacts getTotals() {
        return totals;
    }

    public ProductLineDTO withTotals(NutritionFacts totalNutritionFacts) {
        this.totals = totalNutritionFacts;
        return this;
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
}
