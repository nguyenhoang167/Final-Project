package vn.edu.vnuk.ecommerce.exception.category;

public class CategoryNotFoundException extends Exception {

    public CategoryNotFoundException(long categoryId){
        super("CategoryNotFoundException with id = " + categoryId);
    }
}
