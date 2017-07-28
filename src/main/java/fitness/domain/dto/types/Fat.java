package fitness.domain.dto.types;

import java.util.Optional;

/**
 * Created by toxa on 7/13/2017.
 */
public class Fat{

    private Integer value;

    private Fat(Integer value) {
        this.value = value;
    }

    public static Fat of(Integer value) {
        return new Fat(Optional.ofNullable(value).orElse(0));
    }

    public Integer toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static Fat of(Fat fat) {
        return of(Optional.ofNullable(fat)
                .map(Fat::toInteger).orElse(0));
    }

}
