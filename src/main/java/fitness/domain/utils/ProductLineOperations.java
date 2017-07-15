package fitness.domain.utils;

import fitness.domain.dto.ProductLineDTO;
import fitness.service.utils.ProductHelper;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public enum ProductLineOperations implements ProductLineOperation {

    COUNT_TOTAL_NUTRITION_FACTS {
        @Override
        public ProductLineDTO apply(ProductLineDTO productLineDTO) {
            return ProductHelper.updateTotals(productLineDTO);
        }
    };
}
