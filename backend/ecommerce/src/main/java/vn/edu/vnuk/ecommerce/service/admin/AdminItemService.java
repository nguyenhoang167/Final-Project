package vn.edu.vnuk.ecommerce.service.admin;

import org.springframework.stereotype.Service;
import vn.edu.vnuk.ecommerce.exception.item.ItemNotFoundException;
import vn.edu.vnuk.ecommerce.exception.item.ItemValidationException;
import vn.edu.vnuk.ecommerce.model.Item;

@Service
public interface AdminItemService {

    Item create(Item item) throws ItemValidationException;

    Item update(Long itemId, Item item) throws ItemValidationException, ItemNotFoundException;

    void delete(Long itemId) throws ItemNotFoundException;

}
