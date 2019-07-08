package vn.edu.vnuk.ecommerce.service.admin;

import vn.edu.vnuk.ecommerce.exception.account.AccountNotFoundException;

public interface AdminAccountService {

    void delete(Long id) throws AccountNotFoundException;

}
