package fitness.service.exeption;

import fitness.service.utils.ErrorCodes;

/**
 * Created by Anton_Kramarev on 6/22/2017.
 */
public class ApiException extends RuntimeException {

    private ErrorCodes errorCodes;
    private String[] params;

    public ApiException(ErrorCodes errorCodes, String ... params) {
        this.errorCodes = errorCodes;
        this.params = params;
    }

    public ErrorCodes getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }
}
