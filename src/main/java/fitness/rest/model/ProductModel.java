package fitness.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
public class ProductModel extends ResourceSupport {
    private Long productId;
    private String name;
    private MeasureModel measure;
    private NutritionFactsModel nutritionFacts;


    public String getName() {
        return name;
    }
    @JsonProperty("id")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MeasureModel getMeasure() {
        return measure;
    }

    public void setMeasure(MeasureModel measure) {
        this.measure = measure;
    }

    public NutritionFactsModel getNutritionFacts() {
        return nutritionFacts;
    }

    public void setNutritionFacts(NutritionFactsModel nutritionFacts) {
        this.nutritionFacts = nutritionFacts;
    }
}