package fitness.persistence.converter;

import fitness.domain.dto.types.Protein;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by toxa on 7/14/2017.
 */
@Converter(autoApply = true)
public class ProteinAttributeConverter implements AttributeConverter<Protein, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Protein attribute) {
        if (null == attribute) {
            return null;
        }
        return attribute.toInteger();
    }

    @Override
    public Protein convertToEntityAttribute(Integer dbData) {
        if (null == dbData) {
            return null;
        }
        return Protein.of(dbData);
    }
}
