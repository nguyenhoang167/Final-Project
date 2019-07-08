package vn.edu.vnuk.ecommerce.service.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.edu.vnuk.ecommerce.exception.comment.CommentNotFoundException;
import vn.edu.vnuk.ecommerce.exception.comment.CommentValidationException;
import vn.edu.vnuk.ecommerce.exception.item.ItemNotFoundException;
import vn.edu.vnuk.ecommerce.model.Comment;

public interface CommentService {

    Page<Comment> getAllByItemId(Long itemId, Pageable pageable) throws ItemNotFoundException;

    Comment getOne(Long commentId) throws CommentNotFoundException;
    
    Comment create(Comment comment) throws CommentValidationException;

    Comment update(Long commentId, Comment comment) throws CommentNotFoundException, CommentValidationException;

    void delete(Long commentId) throws CommentNotFoundException;

}