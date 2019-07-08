package vn.edu.vnuk.ecommerce.validation.token;

import vn.edu.vnuk.ecommerce.exception.account.AccountValidationException;
import vn.edu.vnuk.ecommerce.model.OauthAccessToken;

public interface TokenValidation {
    void validate(OauthAccessToken oauthAccessToken, Class groupClassValidation) throws AccountValidationException;
}
