package fitness.rest.model;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Anton_Kramarev on 6/26/2017.
 */
public class ProductLineModel extends ResourceSupport {
    private Long id;
    private Integer value;
    private String productName;
    private NutritionFactsModel totals;
}
