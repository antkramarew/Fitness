package fitness.domain.dto;

import fitness.domain.utils.Recalculable;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
public class Measure{

    public enum  MeasureType implements Recalculable {
        COUNT {
            @Override
            public Integer recalculate(Integer productValue, Integer value) {
                return productValue * value;
            }
        }, WEIGHT{
            @Override
            public Integer recalculate(Integer productValue, Integer lineValue) {
                return productValue * lineValue / MEASURE_VALUE_IN_GRAMS;
            }
        };
        public static final int MEASURE_VALUE_IN_GRAMS = 100;
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
