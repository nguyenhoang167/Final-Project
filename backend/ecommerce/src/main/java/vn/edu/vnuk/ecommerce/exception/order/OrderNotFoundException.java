package vn.edu.vnuk.ecommerce.exception.order;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException(Long orderId) {
        super("OrderNotFoundException with id = " + orderId);
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
