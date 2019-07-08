package vn.edu.vnuk.ecommerce.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.edu.vnuk.ecommerce.exception.category.CategoryNotFoundException;
import vn.edu.vnuk.ecommerce.model.Category;

public interface CategoryService {

    Page<Category> getAll(String keyword, Pageable pageable);

    Category getOne(Long categoryId) throws CategoryNotFoundException;

}