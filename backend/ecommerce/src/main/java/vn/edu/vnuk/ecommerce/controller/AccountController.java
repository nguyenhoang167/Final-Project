package vn.edu.vnuk.ecommerce.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnuk.ecommerce.exception.account.AccountNotFoundException;
import vn.edu.vnuk.ecommerce.exception.account.AccountPasswordIsIncorrectException;
import vn.edu.vnuk.ecommerce.exception.account.AccountValidationException;
import vn.edu.vnuk.ecommerce.exception.common.UnauthorizedException;
import vn.edu.vnuk.ecommerce.exception.email.EmailIsExitException;
import vn.edu.vnuk.ecommerce.exception.token.TokenIsExpiredException;
import vn.edu.vnuk.ecommerce.exception.token.TokenNotFoundException;
import vn.edu.vnuk.ecommerce.model.Account;
import vn.edu.vnuk.ecommerce.service.admin.AdminAccountService;
import vn.edu.vnuk.ecommerce.service.user.AccountService;
import vn.edu.vnuk.ecommerce.service.user.CommonService;
import vn.edu.vnuk.ecommerce.view.View;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AdminAccountService adminAccountService;

    @Autowired
    private CommonService commonService;

    @JsonView(View.Public.class)
    @ResponseBody
    @PostMapping(value = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> create(@RequestBody Account account) throws EmailIsExitException, AccountValidationException {
        return new ResponseEntity<>(accountService.create(account), HttpStatus.OK);
    }

    @JsonView(View.Public.class)
    @ResponseBody
    @GetMapping(value = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Page<Account>> getAll(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
                                                @RequestParam(name = "accessToken") String accessToken,
                                                HttpServletRequest request,
                                                Pageable pageable) throws TokenNotFoundException, UnauthorizedException, TokenIsExpiredException, AccountNotFoundException {
        commonService.authenticate(accessToken, request);

        return new ResponseEntity<>(accountService.getAll(keyword, pageable), HttpStatus.OK);
    }

    @JsonView(View.Public.class)
    @ResponseBody
    @GetMapping(value = "/api/accounts/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getOne(@PathVariable(name = "id") Long id) throws AccountNotFoundException {
        return new ResponseEntity<>(accountService.getOne(id), HttpStatus.OK);
    }

    @JsonView(View.Public.class)
    @ResponseBody
    @PutMapping(value = "/api/accounts/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id,
                                    @RequestParam(name = "accessToken") String accessToken,
                                    HttpServletRequest request,
                                    @RequestBody Account account) throws AccountNotFoundException, AccountValidationException, AccountPasswordIsIncorrectException, TokenNotFoundException, UnauthorizedException, TokenIsExpiredException {
        commonService.authenticate(accessToken, request);

        return new ResponseEntity<>(accountService.update(id, account), HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(value = "/api/accounts/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id,
                                    @RequestParam(name = "accessToken") String accessToken,
                                    HttpServletRequest request) throws AccountNotFoundException, TokenNotFoundException, UnauthorizedException, TokenIsExpiredException {
        commonService.authenticate(accessToken,  request);

        adminAccountService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
