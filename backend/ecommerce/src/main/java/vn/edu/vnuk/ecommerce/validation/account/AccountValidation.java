package vn.edu.vnuk.ecommerce.validation.account;

import vn.edu.vnuk.ecommerce.exception.account.AccountValidationException;
import vn.edu.vnuk.ecommerce.model.Account;

public interface AccountValidation {

    void validate(Account account, Class groupClassValidation) throws AccountValidationException;
}
