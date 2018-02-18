package fitness.domain.dto.types.facts;

public class Fat {

    private int value;

    private Fat(int value) {
        this.value = value;
    }

    public static Fat of(int value) {
        return new Fat(value);
    }

    public int value() {
        return value;
    }

}
