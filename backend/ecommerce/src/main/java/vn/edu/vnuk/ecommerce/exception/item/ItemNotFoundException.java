package vn.edu.vnuk.ecommerce.exception.item;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(Long itemId) {
        super("ItemNotFoundException with id = " + itemId);
    }
}
