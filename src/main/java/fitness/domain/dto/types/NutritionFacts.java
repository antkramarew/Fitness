package fitness.domain.dto.types;

import javax.persistence.Embeddable;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
@Embeddable
public class NutritionFacts {

    private Calories calories;
    private Fat fat;
    private Carbohydrate carbohydrate;
    private Protein protein;

    public NutritionFacts() {
    }

    private NutritionFacts(Calories calories, Fat fat, Carbohydrate carbohydrate, Protein protein) {
        this.calories = calories;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
    }

    public static NutritionFacts of(Calories calories, Fat fat, Carbohydrate carbohydrate, Protein protein) {
        return new NutritionFacts(calories, fat, carbohydrate, protein);
    }

    public static NutritionFacts of(NutritionFacts facts) {
        return NutritionFacts.of(facts.getCalories(), facts.getFat(), facts.getCarbohydrate(), facts.getProtein());
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
