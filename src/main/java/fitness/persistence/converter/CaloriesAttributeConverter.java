package fitness.persistence.converter;

import fitness.domain.dto.types.Calories;
import fitness.domain.dto.types.Protein;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by toxa on 7/14/2017.
 */
@Converter(autoApply = true)
public class CaloriesAttributeConverter implements AttributeConverter<Calories, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Calories attribute) {
        if (null == attribute) {
            return null;
        }
        return attribute.toInteger();
    }

    @Override
    public Calories convertToEntityAttribute(Integer dbData) {
        if (null == dbData) {
            return null;
        }
        return Calories.of(dbData);
    }
}
