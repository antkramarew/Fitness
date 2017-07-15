package fitness.domain.dto.types;

/**
 * Created by toxa on 7/13/2017.
 */
public class Carbohydrate {

    private Integer value;

    private Carbohydrate(Integer value) {
        this.value = value;
    }

    public static Carbohydrate of(Integer value) {
        return new Carbohydrate(value);
    }

    public Integer toInteger() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static Carbohydrate of(Carbohydrate carbohydrate) {
        return of(carbohydrate.toInteger());
    }
}
