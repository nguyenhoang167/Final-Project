package vn.edu.vnuk.ecommerce.validation.account;

import org.springframework.stereotype.Component;
import vn.edu.vnuk.ecommerce.exception.account.AccountValidationException;
import vn.edu.vnuk.ecommerce.model.Account;

import javax.validation.*;
import java.util.HashMap;
import java.util.Set;

@Component
public class AccountValidationImpl implements AccountValidation {

    private static final Validator validator;

    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }

    @Override
    public void validate(Account account, Class groupClassValidation) throws AccountValidationException {
        Set<ConstraintViolation<Account>> constraintViolations = validator.validate(account, groupClassValidation);

        HashMap<String, String> errors = new HashMap<>();

        if(!constraintViolations.isEmpty()){
            for(ConstraintViolation<Account> accountConstraintViolation : constraintViolations){
                errors.put(accountConstraintViolation.getPropertyPath().toString(), accountConstraintViolation.getMessage());
            }

            throw new AccountValidationException(constraintViolations.size(), errors);
        }
    }
}
