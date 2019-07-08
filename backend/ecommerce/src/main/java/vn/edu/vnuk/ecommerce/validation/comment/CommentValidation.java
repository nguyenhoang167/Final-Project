package vn.edu.vnuk.ecommerce.validation.comment;

import vn.edu.vnuk.ecommerce.exception.comment.CommentValidationException;
import vn.edu.vnuk.ecommerce.model.Comment;

public interface CommentValidation {

    void validate(Comment comment, Class groupClassValidation) throws CommentValidationException;

}
