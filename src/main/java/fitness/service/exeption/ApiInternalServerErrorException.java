package fitness.service.exeption;

import fitness.service.utils.ErrorCodes;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public class ApiInternalServerErrorException extends ApiException {
    public ApiInternalServerErrorException() {
        super(ErrorCodes.INTERNAL_SERVER_ERROR);
    }
}
