package fitness.domain.dto.types.facts;

import fitness.domain.dto.types.Measure;

public class Totals {

    private Protein protein;
    private Fat fat;
    private Carbohydrates carbohydrates;
    private Calories calories;
    private Measure measure;

    private Totals(Protein protein, Fat fat, Carbohydrates carbohydrates, Calories calories) {
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public static Totals of(Protein protein, Fat fat, Carbohydrates carbohydrates, Calories calories) {
        return new Totals(protein, fat, carbohydrates, calories);
    }

    public Protein getProtein() {
        return protein;
    }

    public Fat getFat() {
        return fat;
    }

    public Carbohydrates getCarbohydrates() {
        return carbohydrates;
    }

    public Calories getCalories() {
        return calories;
    }

    public Totals multiply(int amount) {
        int defaultAmount = measure.getDefaultAmount();
        return Totals.of(Protein.of(protein.value() * amount / defaultAmount),
        Fat.of(fat.value() * amount / defaultAmount),
        Carbohydrates.of(carbohydrates.value() * amount / defaultAmount),
        Calories.of(calories.value() * amount / defaultAmount));
    }
}
