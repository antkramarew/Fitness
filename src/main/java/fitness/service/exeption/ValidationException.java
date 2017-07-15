package fitness.service.exeption;

import fitness.service.utils.ErrorCode;

import java.util.Set;

/**
 * Created by toxa on 7/13/2017.
 */
public class ValidationException extends RuntimeException{

    private Set<String> errorCodes;

    public ValidationException(Set<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
    public Set<String> getErrorCodes() {
        return errorCodes;
    }
}
