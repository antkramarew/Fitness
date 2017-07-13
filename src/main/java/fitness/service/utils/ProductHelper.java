package fitness.service.utils;

import fitness.domain.dto.Measure;
import fitness.domain.dto.Measure.MeasureType;
import fitness.domain.dto.NutritionFacts;
import fitness.domain.dto.ProductDTO;
import fitness.domain.dto.ProductLineDTO;

/**
 * Created by Anton_Kramarev on 6/22/2017.
 */

public class ProductHelper {

    public static ProductLineDTO recalculateTotalNutritionFacts(ProductLineDTO input) {

        ProductDTO product = input.getProduct();
        Measure measure = product.getMeasure();
        NutritionFacts nutritionFacts = product.getNutritionFacts();
        MeasureType type = measure.getType();
        NutritionFacts totalNutritionFacts = NutritionFacts.of(
                type.recalculate(nutritionFacts.getCalories(), input.getValue()),
                type.recalculate(nutritionFacts.getFat(), input.getValue()),
                type.recalculate(nutritionFacts.getCarbohydrate(), input.getValue()),
                type.recalculate(nutritionFacts.getProtein(), input.getValue())
        );
        input.setTotalNutritionFacts(totalNutritionFacts);
        return input;
    }


}
