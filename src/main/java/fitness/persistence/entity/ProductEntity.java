package fitness.persistence.entity;

import com.google.common.base.Objects;
import fitness.domain.dto.types.Measure;
import fitness.domain.dto.types.NutritionFacts;

import javax.persistence.*;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
@Entity(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Measure measure;
    @Embedded
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
        ProductEntity productEntity = (ProductEntity) o;
        return Objects.equal(id, productEntity.id) &&
                Objects.equal(name, productEntity.name) &&
                Objects.equal(measure, productEntity.measure) &&
                Objects.equal(nutritionFacts, productEntity.nutritionFacts);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, measure, nutritionFacts);
    }
}
