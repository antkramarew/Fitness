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
                source.getCalories() == null ? null : Calories.of(source.getCalories()),
                source.getFat() == null ? null : Fat.of(source.getFat()),
                source.getCarbohydrate() == null ? null : Carbohydrate.of(source.getCarbohydrate()),
                source.getProtein() == null ? null : Protein.of(source.getProtein())
                );
    }
}
