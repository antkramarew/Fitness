package fitness.domain.dto.types.facts;

public class Carbohydrates {

    private int value;

    private Carbohydrates(int value) {
        this.value = value;
    }

    public static Carbohydrates of(int value) {
        return new Carbohydrates(value);
    }

    public int value() {
        return value;
    }

}
