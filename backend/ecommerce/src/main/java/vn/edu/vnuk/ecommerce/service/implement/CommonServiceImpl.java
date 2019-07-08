package vn.edu.vnuk.ecommerce.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import vn.edu.vnuk.ecommerce.constant.Define;
import vn.edu.vnuk.ecommerce.exception.account.AccountNotFoundException;
import vn.edu.vnuk.ecommerce.exception.token.TokenIsExpiredException;
import vn.edu.vnuk.ecommerce.exception.token.TokenNotFoundException;
import vn.edu.vnuk.ecommerce.model.Account;
import vn.edu.vnuk.ecommerce.model.OauthAccessToken;
import vn.edu.vnuk.ecommerce.service.user.AccountService;
import vn.edu.vnuk.ecommerce.service.user.CommonService;
import vn.edu.vnuk.ecommerce.service.user.TokenService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AccountService accountService;

    @Override
    public void authenticate(String accessToken, HttpServletRequest request) throws TokenIsExpiredException, TokenNotFoundException, AccountNotFoundException {
        OauthAccessToken oauthAccessToken = tokenService.get(accessToken);

        Account account = accountService.getOne(oauthAccessToken.getAccountId());
        String role = (account.getRoleId() == Define.ROLE_ADMIN) ? Define.STR_ROLE_ADMIN : Define.STR_ROLE_NORMAL_USER;

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        UserDetails userDetails = new User(account.getEmail(), "", authorities);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
