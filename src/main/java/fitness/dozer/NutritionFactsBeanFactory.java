package fitness.dozer;

import fitness.domain.dto.types.*;
import org.dozer.BeanFactory;

/**
 * Created by toxa on 7/14/2017.
 */
public class NutritionFactsBeanFactory implements BeanFactory{
    @Override
    public Object createBean(Object obj, Class<?> aClass, String s) {
        final NutritionFacts source = (NutritionFacts) (obj);
        return new NutritionFacts(
                Calories.of(source.getCalories()),
                Fat.of(source.getFat()),
                Carbohydrate.of(source.getCarbohydrate()),
                Protein.of(source.getProtein())
                );
    }
}
