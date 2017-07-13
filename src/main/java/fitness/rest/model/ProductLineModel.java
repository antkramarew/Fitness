package fitness.rest.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Anton_Kramarev on 6/26/2017.
 */
public class ProductLineModel extends ResourceSupport {
    private Long id;
    private ProductModel product;
    private Integer value;
    private NutritionFactsModel totalNutritionFacts;
}
