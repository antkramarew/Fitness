package fitness.domain.dto.types;

import com.google.common.base.Objects;

import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

/**
 * Created by toxa on 7/13/2017.
 */
public class Calories {

    private Integer value;

    private Calories(Integer value) {
        this.value = value;
    }

    public static Calories of(Integer value) {
        return new Calories(ofNullable(value)
                .orElse(0));
    }

    public static Calories of(Calories c) {
        return Calories.of(ofNullable(c)
                .map(Calories::toInteger).orElse(0));
    }
    public Integer toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
