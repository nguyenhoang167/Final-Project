package vn.edu.vnuk.ecommerce.exception.account;

public class AccountInvalidException extends Exception{

    public AccountInvalidException(String message){
        super("AccountInvalidException with message = " + message);
    }

    public AccountInvalidException(){
        super("AccountInvalidException");
    }
}
