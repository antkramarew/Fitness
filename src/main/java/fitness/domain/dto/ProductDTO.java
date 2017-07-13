package fitness.domain.dto;

import com.google.common.base.Objects;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */

public class ProductDTO {
    private Long id;
    private String name;
    private Measure measure;
    private NutritionFacts nutritionFacts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public NutritionFacts getNutritionFacts() {
        return nutritionFacts;
    }

    public void setNutritionFacts(NutritionFacts nutritionFacts) {
        this.nutritionFacts = nutritionFacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO productDTO = (ProductDTO) o;
        return Objects.equal(id, productDTO.id) &&
                Objects.equal(name, productDTO.name) &&
                Objects.equal(measure, productDTO.measure) &&
                Objects.equal(nutritionFacts, productDTO.nutritionFacts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, measure, nutritionFacts);
    }
}
