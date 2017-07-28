package fitness.dozer;

import fitness.domain.dto.types.Protein;
import org.dozer.BeanFactory;

/**
 * Created by Anton_Kramarev on 7/24/2017.
 */
public class ProteinBeanFactory implements BeanFactory {
    @Override
    public Object createBean(Object source, Class<?> sourceClass, String targetBeanId) {
        final Protein sourceObj = (Protein) (source);
        return Protein.of(sourceObj);
    }
}
