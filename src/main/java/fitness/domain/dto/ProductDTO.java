package fitness.domain.dto;

import com.google.common.base.Objects;
import fitness.domain.dto.types.*;
import fitness.service.utils.ValidationConstants;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */

public class ProductDTO {
    private Long id;

    @NotEmpty(message = ValidationConstants.PRODUCT_NAME_IS_EMPTY )
    @Size(max = 256, message = ValidationConstants.PRODUCT_NAME_TOO_LONG)
    private String name;
    @NotNull
    private Measure measure;

    private Protein protein;
    private Calories calories;
    private Fat fat;
    private Carbohydrate carbohydrate;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Protein getProtein() {
        return protein;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }

    public Calories getCalories() {
        return calories;
    }

    public void setCalories(Calories calories) {
        this.calories = calories;
    }

    public Fat getFat() {
        return fat;
    }

    public void setFat(Fat fat) {
        this.fat = fat;
    }

    public Carbohydrate getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Carbohydrate carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
