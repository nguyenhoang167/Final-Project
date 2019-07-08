package vn.edu.vnuk.ecommerce.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnuk.ecommerce.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Query("FROM Comment comment WHERE comment.itemId = :itemId")
    Page<Comment> findAllByItemId(Long itemId, Pageable pageable);

}