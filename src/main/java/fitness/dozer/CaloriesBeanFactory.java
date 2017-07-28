package fitness.dozer;

import fitness.domain.dto.types.Calories;
import fitness.domain.dto.types.Fat;
import org.dozer.BeanFactory;

/**
 * Created by Anton_Kramarev on 7/24/2017.
 */
public class CaloriesBeanFactory implements BeanFactory {
    @Override
    public Object createBean(Object source, Class<?> sourceClass, String targetBeanId) {
        final Calories sourceObj = (Calories) (source);
        return Calories.of(sourceObj);
    }
}
