package vn.edu.vnuk.ecommerce.exception.account;

public class AccountPasswordIsIncorrectException extends Exception {

    public AccountPasswordIsIncorrectException(String message){
        super("AccountPasswordIsIncorrect with message = " + message);
    }
}
