package vn.edu.vnuk.ecommerce.exception.token;

public class TokenNotFoundException extends Exception {

    public TokenNotFoundException(String accessToken){
        super("TokenNotFoundException with accessToken = " + accessToken);
    }
}
