package fitness.service.utils;

/**
 * Created by Anton_Kramarev on 6/22/2017.
 */
public enum ErrorCodes {

    PRODUCT_LINE_NOT_FOUND("Product line with provided id: %s not found"),
    PRODUCT_NOT_FOUND("Product with provided id: %s not found"),
    INTERNAL_SERVER_ERROR("Unknown server error occurred");

    private final String message;

    ErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
