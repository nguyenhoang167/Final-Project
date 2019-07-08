package vn.edu.vnuk.ecommerce.exception.orderAddress;

public class OrderAddressNotFoundException extends Exception {

    public OrderAddressNotFoundException(Long orderAddressId) {
        super("OrderAddressNotFoundException with id = " + orderAddressId);
    }

    public OrderAddressNotFoundException(String message) {
        super(message);
    }
}
