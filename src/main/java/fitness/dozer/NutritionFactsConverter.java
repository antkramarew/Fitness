package fitness.dozer;

import fitness.domain.dto.types.*;
import fitness.rest.model.Totals;
import org.dozer.DozerConverter;

/**
 * Created by toxa on 7/14/2017.
 */
public class NutritionFactsConverter extends DozerConverter<NutritionFacts, Totals> {
    public NutritionFactsConverter() {
        super(NutritionFacts.class, Totals.class);
    }

    @Override
    public Totals convertTo(NutritionFacts dto, Totals input) {
        if (null == dto) {
            return null;
        }
        Totals model = new Totals();
        model.setCalories(dto.getCalories().toInteger());
        model.setCarbohydrate(dto.getCarbohydrate().toInteger());
        model.setFat(dto.getFat().toInteger());
        model.setProtein(dto.getProtein().toInteger());
        return model;
    }

    @Override
    public NutritionFacts convertFrom(Totals model, NutritionFacts input) {
        if (null == model) {
            return null;
        }
        NutritionFacts dto = new NutritionFacts();
        dto.setCalories(Calories.of(model.getCalories()));
        dto.setCarbohydrate(Carbohydrate.of(model.getCarbohydrate()));
        dto.setFat(Fat.of(model.getFat()));
        dto.setProtein(Protein.of(model.getProtein()));
        return dto;
    }
}
