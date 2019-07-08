package vn.edu.vnuk.ecommerce.service.admin;

import vn.edu.vnuk.ecommerce.exception.category.CategoryIsExistException;
import vn.edu.vnuk.ecommerce.exception.category.CategoryNotFoundException;
import vn.edu.vnuk.ecommerce.exception.category.CategoryValidationException;
import vn.edu.vnuk.ecommerce.model.Category;

public interface AdminCategoryService {

    Category create(Category category) throws CategoryValidationException, CategoryIsExistException;

    Category update(Long categoryId, Category category) throws CategoryNotFoundException, CategoryValidationException, CategoryIsExistException;

    void delete(Long categoryId) throws CategoryNotFoundException;

}