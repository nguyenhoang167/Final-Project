package vn.edu.vnuk.ecommerce.exception.token;

public class TokenIsExpiredException extends Exception {

    public TokenIsExpiredException(String token){
        super("TokenIsExpiredException with token = " + token);
    }
}
