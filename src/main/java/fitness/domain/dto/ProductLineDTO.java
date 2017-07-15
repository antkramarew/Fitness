package fitness.domain.dto;

import fitness.domain.dto.types.NutritionFacts;
import fitness.domain.utils.ProductLineOperation;

import javax.validation.constraints.NotNull;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public class ProductLineDTO {

    private Long id;
    @NotNull
    private ProductDTO product;
    @NotNull
    private Integer value;
    private NutritionFacts totals;

    private ProductLineDTO(Long id, ProductDTO product, Integer value, NutritionFacts totals) {
        this.id = id;
        this.product = product;
        this.value = value;
        this.totals = totals;
    }

    public static ProductLineDTO of(Long id, ProductDTO product, Integer value, NutritionFacts totalNutritionFacts) {
        return new ProductLineDTO(id, product, value, totalNutritionFacts);
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
}
