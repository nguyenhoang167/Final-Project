package vn.edu.vnuk.ecommerce.exception.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.edu.vnuk.ecommerce.model.ApiError;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
public class OrderExceptionHandler {

    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity<ApiError> handleOrderNotFoundException(HttpServletRequest request, Exception ex) {
        HashMap<String, String> errors = new HashMap<>();
        errors.put("message", "order not found");

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(),
                                        errors,
                                        ex.getMessage(),
                                        request.getRequestURI());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OrderValidationException.class)
    public ResponseEntity<ApiError> handleOrderValidationException(HttpServletRequest request, Exception ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_ACCEPTABLE.value(),
                                        ((OrderValidationException) ex).getErrors(),
                                        ex.getMessage(),
                                        request.getRequestURI());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_ACCEPTABLE);
    }
}
