package vn.edu.vnuk.ecommerce.service.user;

import vn.edu.vnuk.ecommerce.exception.account.AccountIsLockedException;
import vn.edu.vnuk.ecommerce.exception.account.AccountValidationException;
import vn.edu.vnuk.ecommerce.exception.email.EmailAndPasswordIsIncorrectException;
import vn.edu.vnuk.ecommerce.exception.token.TokenIsExpiredException;
import vn.edu.vnuk.ecommerce.exception.token.TokenNotFoundException;
import vn.edu.vnuk.ecommerce.model.Account;
import vn.edu.vnuk.ecommerce.model.OauthAccessToken;

public interface TokenService {

    OauthAccessToken create(Account account) throws EmailAndPasswordIsIncorrectException, AccountValidationException, AccountIsLockedException;

    boolean isTokenExpired(OauthAccessToken oauthAccessToken);

    OauthAccessToken get(String accessToken) throws TokenNotFoundException, TokenIsExpiredException;

    void delete(String accessToken) throws TokenNotFoundException;
}
