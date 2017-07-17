package fitness.domain.dto.types;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Created by toxa on 7/13/2017.
 */
public class Fat {

    private Integer value;

    private Fat(Integer value) {
        this.value = value;
    }

    public static Fat of(Integer value) {
        requireNonNull(value);
        return new Fat(value);
    }

    public Integer toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static Fat of(Fat fat) {
        requireNonNull(fat);
        return of(fat.toInteger());
    }
}
