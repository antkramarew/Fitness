package fitness.domain.dto.types;

import fitness.domain.dto.types.facts.Nutrition;
import fitness.domain.dto.types.facts.Totals;

public class ProductDTO implements Nutrition {

    private Long id;
    private String name;
    private Totals totals;

    public ProductDTO(Long id, String name, Totals totals) {
        this.id = id;
        this.name = name;
        this.totals = totals;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public Totals getTotals() {
        return totals;
    }
}
