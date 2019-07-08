package vn.edu.vnuk.ecommerce.validation.OrderAddress;

import vn.edu.vnuk.ecommerce.exception.orderAddress.OrderAddressValidationException;
import vn.edu.vnuk.ecommerce.model.OrderAddress;

public interface OrderAddressValidation {
    void validate(OrderAddress orderAddress, Class groupClassValidation) throws OrderAddressValidationException;
}
