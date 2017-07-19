package fitness.service.utils;

import fitness.domain.dto.ProductDTO;
import fitness.domain.dto.ProductLineDTO;
import fitness.domain.dto.types.*;

/**
 * Created by Anton_Kramarev on 6/22/2017.
 */

public class ProductHelper {

    public static ProductLineDTO updateTotals(ProductLineDTO line) {

        ProductDTO product = line.getProduct();
        Measure measure = product.getMeasure();
        NutritionFacts facts = product.getNutritionFacts();

        Integer lineValue = line.getValue();
        NutritionFacts totals = NutritionFacts.of(
                Calories.of(measure.apply(facts.getCalories().toInteger(), lineValue)),
                Fat.of(measure.apply(facts.getFat().toInteger(), lineValue)),
                Carbohydrate.of(measure.apply(facts.getCarbohydrate().toInteger(), lineValue)),
                Protein.of(measure.apply(facts.getProtein().toInteger(), lineValue))
        );

        return line.withTotals(totals);
    }


}
