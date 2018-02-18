package fitness.domain.dto.types.facts;

public class Calories {

    private int value;

    private Calories(int value) {
        this.value = value;
    }

    public static Calories of(int value) {
        return new Calories(value);
    }

    public int value() {
        return value;
    }

}
