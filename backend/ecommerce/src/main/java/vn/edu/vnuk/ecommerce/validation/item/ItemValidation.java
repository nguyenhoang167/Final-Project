package vn.edu.vnuk.ecommerce.validation.item;

import vn.edu.vnuk.ecommerce.exception.item.ItemValidationException;
import vn.edu.vnuk.ecommerce.model.Item;

public interface ItemValidation {
    void validate(Item item, Class groupClassValidation) throws ItemValidationException;
}
