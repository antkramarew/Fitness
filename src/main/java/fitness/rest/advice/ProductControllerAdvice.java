package fitness.rest.advice;

import fitness.service.exeption.ApiNotFoundException;
import fitness.service.utils.ErrorCodes;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Anton_Kramarev on 6/19/2017.
 */
@ControllerAdvice
public class ProductControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ApiNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors apiExceptionHandler(ApiNotFoundException exc) {
        ErrorCodes errorCodes = exc.getErrorCodes();
        return new VndErrors(errorCodes.toString(),
                String.format(errorCodes.getMessage(), exc.getParams()));
    }

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    VndErrors apiInternalServerErrorHandler(Throwable throwable) {
        throwable.printStackTrace();
        return new VndErrors(ErrorCodes.INTERNAL_SERVER_ERROR.toString(), ErrorCodes.INTERNAL_SERVER_ERROR.getMessage());
    }
}
