package fitness.service.exeption;

import fitness.service.utils.ErrorCodes;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public class ProductLineNotFoundException extends ApiNotFoundException {
    public ProductLineNotFoundException(Long id) {
        super(ErrorCodes.PRODUCT_LINE_NOT_FOUND, id.toString());
    }
}
