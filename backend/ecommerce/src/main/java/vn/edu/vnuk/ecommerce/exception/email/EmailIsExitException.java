package vn.edu.vnuk.ecommerce.exception.email;

public class EmailIsExitException extends Exception {

    public EmailIsExitException(String email) {
        super("EmailIsExitException with email = " + email);
    }
}
