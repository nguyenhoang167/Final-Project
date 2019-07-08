package vn.edu.vnuk.ecommerce.exception.account;

public class AccountIsExistException extends Exception{

    public AccountIsExistException(String email){
        super("AccountIsExistException with email = " + email);
    }
}
