package vn.edu.vnuk.ecommerce.exception.account;

public class AccountIsLockedException extends Exception {
    public AccountIsLockedException(Long id) {
        super("AccountIsLockedException with id = " + id);
    }
}
