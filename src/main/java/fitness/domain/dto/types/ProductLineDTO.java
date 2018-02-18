package fitness.domain.dto.types;

import fitness.domain.dto.types.facts.Nutrition;
import fitness.domain.dto.types.facts.Totals;

public class ProductLineDTO implements Nutrition {

    private Long id;
    private ProductDTO product;
    private int amount;
    private Totals totals;

    public ProductLineDTO(Long id, ProductDTO product, int amount) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.totals = product.getTotals().multiply(amount);
    }

    @Override
    public Totals getTotals() {
        return totals;
    }

    public Long getId() {
        return id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}
