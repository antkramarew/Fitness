package fitness.persistance.entity;

import javax.persistence.Embeddable;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
@Embeddable
public class Measure {

    enum  MeasureType {
        COUNT, WEIGHT
    }
    private MeasureType type;

    private Integer value;

    public MeasureType getType() {
        return type;
    }

    public void setType(MeasureType type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
