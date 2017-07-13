package fitness.service.exeption;

import fitness.service.utils.ErrorCodes;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public class ApiNotFoundException extends ApiException{

    public ApiNotFoundException(ErrorCodes errorCodes, String... params) {
        super(errorCodes, params);
    }
}
