package fitness.persistence.converter;

import fitness.domain.dto.types.Fat;
import fitness.domain.dto.types.Protein;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by toxa on 7/14/2017.
 */
@Converter(autoApply = true)
public class FatAttributeConverter implements AttributeConverter<Fat, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Fat attribute) {
        if (null == attribute) {
            return null;
        }
        return attribute.toInteger();
    }

    @Override
    public Fat convertToEntityAttribute(Integer dbData) {
        if (null == dbData) {
            return null;
        }
        return Fat.of(dbData);
    }
}
