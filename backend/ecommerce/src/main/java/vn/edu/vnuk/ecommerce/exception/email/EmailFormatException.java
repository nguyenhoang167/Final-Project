package vn.edu.vnuk.ecommerce.exception.email;

public class EmailFormatException extends Exception{

    public EmailFormatException(String email){
        super("EmailFormatException with email = " + email);
    }
}
