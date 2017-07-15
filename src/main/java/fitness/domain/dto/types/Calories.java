package fitness.domain.dto.types;

import com.google.common.base.Objects;

/**
 * Created by toxa on 7/13/2017.
 */
public class Calories implements Cloneable{

    private Integer value;

    private Calories(Integer value) {
        this.value = value;
    }

    public static Calories of(Integer value) {
        return new Calories(value);
    }

    public static Calories of(Calories calories) {
        return Calories.of(calories.toInteger());
    }

    public Integer toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
