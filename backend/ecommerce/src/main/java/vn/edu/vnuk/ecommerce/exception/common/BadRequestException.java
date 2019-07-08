package vn.edu.vnuk.ecommerce.exception.common;

public class BadRequestException extends Exception {

    public BadRequestException(String message) {
        super("BadRequestException with message = " + message);
    }
}
