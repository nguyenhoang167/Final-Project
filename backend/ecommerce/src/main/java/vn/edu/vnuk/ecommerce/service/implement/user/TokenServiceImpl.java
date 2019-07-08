package vn.edu.vnuk.ecommerce.service.implement.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.vnuk.ecommerce.constant.Define;
import vn.edu.vnuk.ecommerce.exception.account.AccountIsLockedException;
import vn.edu.vnuk.ecommerce.exception.account.AccountValidationException;
import vn.edu.vnuk.ecommerce.exception.email.EmailAndPasswordIsIncorrectException;
import vn.edu.vnuk.ecommerce.exception.token.TokenIsExpiredException;
import vn.edu.vnuk.ecommerce.exception.token.TokenNotFoundException;
import vn.edu.vnuk.ecommerce.model.Account;
import vn.edu.vnuk.ecommerce.model.OauthAccessToken;
import vn.edu.vnuk.ecommerce.repository.AccountRepository;
import vn.edu.vnuk.ecommerce.repository.OauthAccessTokenRepository;
import vn.edu.vnuk.ecommerce.service.user.TokenService;
import vn.edu.vnuk.ecommerce.validation.account.AccountValidation;
import vn.edu.vnuk.ecommerce.validation.account.GroupLoginAccount;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private OauthAccessTokenRepository oauthAccessTokenRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountValidation accountValidation;

    @Transactional
    @Override
    public OauthAccessToken create(Account accountParam) throws EmailAndPasswordIsIncorrectException, AccountValidationException, AccountIsLockedException {
        accountValidation.validate(accountParam, GroupLoginAccount.class);

        boolean isCorrect = true;
        String email = accountParam.getEmail(), password = accountParam.getPassword();

        Account account = accountRepository.getByEmail(email);

        if (account == null) isCorrect = false;

        if (!passwordEncoder.matches(password, account.getPassword())) isCorrect = false;

        if (!isCorrect) throw new EmailAndPasswordIsIncorrectException(email, password);

        if (account.getStatus() == Define.STATUS_DELETED_ACCOUNT) throw new AccountIsLockedException(account.getId());

        OauthAccessToken oauthAccessToken = new OauthAccessToken();
        oauthAccessToken.setAccessToken(DigestUtils.sha256Hex(account.getId() + account.getEmail() + (new Date().getTime())));
        oauthAccessToken.setExpires(Define.TIME_OF_TOKEN);
        oauthAccessToken.setExpiredAt(new Date((new Date()).getTime() + Define.TIME_OF_TOKEN * 1000));
        oauthAccessToken.setStatus(Define.STATUS_CREATED_TOKEN);
        oauthAccessToken.setAccountId(account.getId());

        oauthAccessToken = oauthAccessTokenRepository.save(oauthAccessToken);
        oauthAccessToken.setAccount(accountRepository.findById(oauthAccessToken.getAccountId()).get());

        return oauthAccessToken;
    }

    @Override
    public boolean isTokenExpired(OauthAccessToken oauthAccessToken) {
        return (new Date()).getTime() >= oauthAccessToken.getExpiredAt().getTime();
    }

    @Override
    public OauthAccessToken get(String accessToken) throws TokenNotFoundException, TokenIsExpiredException {
        OauthAccessToken oauthAccessToken = oauthAccessTokenRepository.getByAccessToken(accessToken);

        if (oauthAccessToken == null) throw new TokenNotFoundException(accessToken);

        if (isTokenExpired(oauthAccessToken)) throw new TokenIsExpiredException(accessToken);

        return oauthAccessToken;
    }

    @Override
    public void delete(String accessToken) throws TokenNotFoundException {
        OauthAccessToken oauthAccessToken = oauthAccessTokenRepository.getByAccessToken(accessToken);

        if (oauthAccessToken == null) throw new TokenNotFoundException(accessToken);

        oauthAccessToken.setStatus(Define.STATUS_DELETED_TOKEN);
        oauthAccessTokenRepository.save(oauthAccessToken);
    }

}
