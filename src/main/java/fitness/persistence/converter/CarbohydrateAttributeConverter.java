package fitness.persistence.converter;

import fitness.domain.dto.types.Carbohydrate;
import fitness.domain.dto.types.Protein;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by toxa on 7/14/2017.
 */
@Converter(autoApply = true)
public class CarbohydrateAttributeConverter implements AttributeConverter<Carbohydrate, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Carbohydrate attribute) {
        if (null == attribute) {
            return null;
        }
        return attribute.toInteger();
    }

    @Override
    public Carbohydrate convertToEntityAttribute(Integer dbData) {
        if (null == dbData) {
            return null;
        }
        return Carbohydrate.of(dbData);
    }
}
