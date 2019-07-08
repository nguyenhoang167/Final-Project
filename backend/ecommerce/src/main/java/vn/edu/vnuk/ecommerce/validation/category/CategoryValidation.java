package vn.edu.vnuk.ecommerce.validation.category;

import vn.edu.vnuk.ecommerce.exception.category.CategoryValidationException;
import vn.edu.vnuk.ecommerce.model.Category;

public interface CategoryValidation {

    void validate(Category category, Class classGroupValidation) throws CategoryValidationException;
}
