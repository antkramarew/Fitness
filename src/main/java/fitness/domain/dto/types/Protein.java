package fitness.domain.dto.types;

import java.util.Optional;

/**
 * Created by toxa on 7/13/2017.
 */
public class Protein {

    private Integer value;

    private Protein(Integer value) {
        this.value = value;
    }

    public static Protein of(Integer value) {
        return new Protein(Optional.ofNullable(value).orElse(0));
    }

    public Integer toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static Protein of(Protein protein) {
        return of(Optional.ofNullable(protein)
                .map(Protein::toInteger).orElse(0));
    }
}
