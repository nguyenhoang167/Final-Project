package vn.edu.vnuk.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import vn.edu.vnuk.ecommerce.model.Rating;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Long> {

    List<Rating> findAllByItemId(Long itemId);
}
