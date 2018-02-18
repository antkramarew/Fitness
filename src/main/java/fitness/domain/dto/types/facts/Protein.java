package fitness.domain.dto.types.facts;

public class Protein {

    private int value;

    private Protein(int value) {
        this.value = value;
    }

    public static Protein of(int value) {
        return new Protein(value);
    }
    public static Protein of(Protein protein) {
        return new Protein(protein.value());
    }

    public int value() {
        return value;
    }

}
