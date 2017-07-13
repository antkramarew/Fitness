package fitness.domain.dto;

import javax.validation.constraints.NotNull;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
public class NutritionFacts {

    @NotNull
    private Integer calories;
    @NotNull
    private Integer fat;
    @NotNull
    private Integer carbohydrate;
    @NotNull
    private Integer protein;

    private NutritionFacts(Integer calories, Integer fat, Integer carbohydrate, Integer protein) {
        this.calories = calories;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
    }

    public static NutritionFacts of(Integer calories, Integer fat, Integer carbohydrate, Integer protein) {
        return new NutritionFacts(calories, fat, carbohydrate, protein);
    }

    public Integer getCalories() {
        return calories;
    }

    public Integer getFat() {
        return fat;
    }

    public Integer getCarbohydrate() {
        return carbohydrate;
    }

    public Integer getProtein() {
        return protein;
    }

}
