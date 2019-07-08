package vn.edu.vnuk.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnuk.ecommerce.model.DiscountPrice;

@Repository
public interface DiscountPriceRepository extends CrudRepository<DiscountPrice, Long> {
}