package fitness.dozer;

import fitness.domain.dto.types.Fat;
import fitness.domain.dto.types.Protein;
import org.dozer.BeanFactory;

/**
 * Created by Anton_Kramarev on 7/24/2017.
 */
public class FatBeanFactory implements BeanFactory {
    @Override
    public Object createBean(Object source, Class<?> sourceClass, String targetBeanId) {
        final Fat sourceObj = (Fat) (source);
        return Fat.of(sourceObj);
    }
}
