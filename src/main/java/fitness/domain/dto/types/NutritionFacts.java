package fitness.domain.dto.types;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
@Embeddable
public class NutritionFacts {

    @NotNull
    private Calories calories;
    @NotNull
    private Fat fat;
    @NotNull
    private Carbohydrate carbohydrate;
    @NotNull
    private Protein protein;

    public NutritionFacts() {
    }

    public NutritionFacts(Calories calories, Fat fat, Carbohydrate carbohydrate, Protein protein) {
        this.calories = calories;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
    }

    public Calories getCalories() {
        return calories;
    }

    public Fat getFat() {
        return fat;
    }

    public Carbohydrate getCarbohydrate() {
        return carbohydrate;
    }

    public Protein getProtein() {
        return protein;
    }

    public void setCalories(Calories calories) {
        this.calories = calories;
    }

    public void setFat(Fat fat) {
        this.fat = fat;
    }

    public void setCarbohydrate(Carbohydrate carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }
}
