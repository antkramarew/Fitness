package fitness.domain.dto;

import fitness.domain.utils.ProductLineOperation;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public class ProductLineDTO {

    private Long id;
    private ProductDTO product;
    private Integer value;
    private NutritionFacts totalNutritionFacts;

    public ProductLineDTO apply(ProductLineOperation operation) {
        return operation.apply(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public NutritionFacts getTotalNutritionFacts() {
        return totalNutritionFacts;
    }

    public void setTotalNutritionFacts(NutritionFacts totalNutritionFacts) {
        this.totalNutritionFacts = totalNutritionFacts;
    }
}
