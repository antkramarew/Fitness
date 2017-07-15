package fitness.dozer;

import fitness.domain.dto.types.*;
import fitness.rest.model.NutritionFactsModel;
import org.dozer.DozerConverter;

/**
 * Created by toxa on 7/14/2017.
 */
public class NutritionFactsConverter extends DozerConverter<NutritionFacts, NutritionFactsModel> {
    public NutritionFactsConverter() {
        super(NutritionFacts.class, NutritionFactsModel.class);
    }

    @Override
    public NutritionFactsModel convertTo(NutritionFacts dto, NutritionFactsModel input) {
        if (null == dto) {
            return null;
        }
        NutritionFactsModel model = new NutritionFactsModel();
        model.setCalories(dto.getCalories().toInteger());
        model.setCarbohydrate(dto.getCarbohydrate().toInteger());
        model.setFat(dto.getFat().toInteger());
        model.setProtein(dto.getProtein().toInteger());
        return model;
    }

    @Override
    public NutritionFacts convertFrom(NutritionFactsModel model, NutritionFacts input) {
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
