package vn.edu.vnuk.ecommerce.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.edu.vnuk.ecommerce.exception.category.CategoryNotFoundException;
import vn.edu.vnuk.ecommerce.exception.item.ItemNotFoundException;
import vn.edu.vnuk.ecommerce.model.Item;

import java.util.List;

public interface ItemService {

    Page<Item> getAll(Pageable pageable);

    Page<Item> getAll(Pageable pageable, List<Long> itemIds);

    Page<Item> getAll(Long categoryId, Pageable pageable) throws CategoryNotFoundException;

    Item getOne(Long itemId) throws ItemNotFoundException;
}
