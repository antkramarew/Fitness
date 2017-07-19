package fitness.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Anton_Kramarev on 6/26/2017.
 */
public class ProductLineResponseModel extends ResourceSupport {
    private Long lineId;
    private Integer value;
    private String productName;
    private NutritionFactsModel totals;

    @JsonProperty("id")
    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public NutritionFactsModel getTotals() {
        return totals;
    }

    public void setTotals(NutritionFactsModel totals) {
        this.totals = totals;
    }

}
