package vn.edu.vnuk.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnuk.ecommerce.exception.account.AccountIsLockedException;
import vn.edu.vnuk.ecommerce.exception.account.AccountValidationException;
import vn.edu.vnuk.ecommerce.exception.email.EmailAndPasswordIsIncorrectException;
import vn.edu.vnuk.ecommerce.exception.token.TokenNotFoundException;
import vn.edu.vnuk.ecommerce.model.Account;
import vn.edu.vnuk.ecommerce.service.user.TokenService;

@Controller
public class CommonController {

    @Autowired
    private TokenService tokenService;




    @ResponseBody
    @PostMapping(value =  "/api/login", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> login(@RequestBody Account account) throws EmailAndPasswordIsIncorrectException, AccountValidationException, AccountIsLockedException {

        return new ResponseEntity<>(tokenService.create(account), HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping(value = "/api/logout", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> logout(@RequestParam("accessToken") String accessToken) throws TokenNotFoundException {
        tokenService.delete(accessToken);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}