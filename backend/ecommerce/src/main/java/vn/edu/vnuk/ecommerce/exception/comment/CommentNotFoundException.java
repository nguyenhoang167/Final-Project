package vn.edu.vnuk.ecommerce.exception.comment;

public class CommentNotFoundException extends Exception {

    public CommentNotFoundException(Long commentId) {
        super("CommentNotFoundException with commentId = " + commentId);
    }
}
