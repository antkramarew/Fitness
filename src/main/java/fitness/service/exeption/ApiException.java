package fitness.service.exeption;

import fitness.service.utils.ErrorCode;

import java.util.Objects;

/**
 * Created by Anton_Kramarev on 6/22/2017.
 */
public class ApiException extends RuntimeException {

    private ErrorCode errorCode;
    private Object[] params;

    public ApiException(ErrorCode errorCode, Object ... params) {
        this.errorCode = errorCode;
        this.params = params;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String errorCodeToString() {
        return errorCode.toString();
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public String getMessage() {
        return String.format(errorCode.getMessage(), params);
    }
}
