package vn.edu.vnuk.ecommerce.validation.Order;

import vn.edu.vnuk.ecommerce.exception.order.OrderValidationException;
import vn.edu.vnuk.ecommerce.model.Order;

public interface OrderValidation {
    void validate(Order order, Class groupClassValidation) throws OrderValidationException;
}
