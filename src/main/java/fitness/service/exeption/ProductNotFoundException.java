package fitness.service.exeption;

import fitness.service.utils.ErrorCodes;

/**
 * Created by Anton_Kramarev on 6/22/2017.
 */
public class ProductNotFoundException extends ApiNotFoundException {
    public ProductNotFoundException(Long productId) {
       super(ErrorCodes.PRODUCT_NOT_FOUND, productId.toString());
    }
}
