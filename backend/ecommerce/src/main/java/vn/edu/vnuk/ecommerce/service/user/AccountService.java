package vn.edu.vnuk.ecommerce.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.edu.vnuk.ecommerce.exception.account.AccountNotFoundException;
import vn.edu.vnuk.ecommerce.exception.account.AccountPasswordIsIncorrectException;
import vn.edu.vnuk.ecommerce.exception.account.AccountValidationException;
import vn.edu.vnuk.ecommerce.exception.email.EmailIsExitException;
import vn.edu.vnuk.ecommerce.model.Account;

public interface AccountService {

    Account create(Account account) throws EmailIsExitException, AccountValidationException;

    Page<Account> getAll(String keyword, Pageable pageable);

    Account getOne(Long id) throws AccountNotFoundException;

    Account update(Long id, Account account) throws AccountNotFoundException, AccountValidationException, AccountPasswordIsIncorrectException;

    Account getAccountLogin();

    boolean isAccountLogin(long accountId);

}
