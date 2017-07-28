package fitness.dozer;

import fitness.domain.dto.types.Calories;
import fitness.domain.dto.types.Carbohydrate;
import org.dozer.BeanFactory;

/**
 * Created by Anton_Kramarev on 7/24/2017.
 */
public class CarbohydrateBeanFactory implements BeanFactory {
    @Override
    public Object createBean(Object source, Class<?> sourceClass, String targetBeanId) {
        final Carbohydrate sourceObj = (Carbohydrate) (source);
        return Carbohydrate.of(sourceObj);
    }
}
