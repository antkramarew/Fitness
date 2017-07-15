package fitness.domain.dto;

import com.google.common.base.Objects;
import fitness.domain.dto.types.Measure;
import fitness.domain.dto.types.NutritionFacts;
import fitness.service.utils.ErrorCode;
import fitness.service.utils.ValidationConstants;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.hql.internal.ast.ErrorCounter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */

public class ProductDTO {
    private Long id;

    @NotEmpty
    @Size(max = 256, message = ValidationConstants.PRODUCT_NAME_TOO_LONG)
    private String name;
    @NotNull
    private Measure measure;
    @NotNull(message = ValidationConstants.NUTRITION_FACTS_REQUIRED)
    @Valid
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
