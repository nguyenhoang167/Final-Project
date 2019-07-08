package vn.edu.vnuk.ecommerce.service.user;

import org.springframework.context.annotation.Lazy;
import vn.edu.vnuk.ecommerce.exception.account.AccountNotFoundException;
import vn.edu.vnuk.ecommerce.exception.token.TokenIsExpiredException;
import vn.edu.vnuk.ecommerce.exception.token.TokenNotFoundException;
import vn.edu.vnuk.ecommerce.exception.common.UnauthorizedException;

import javax.servlet.http.HttpServletRequest;


@Lazy
public interface CommonService {

    void authenticate(String accessToken, HttpServletRequest request) throws TokenNotFoundException, UnauthorizedException, TokenIsExpiredException, AccountNotFoundException;

}
