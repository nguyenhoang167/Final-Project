package vn.edu.vnuk.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnuk.ecommerce.model.OrderHasItem;

@Repository
public interface OrderHasItemRepository extends CrudRepository<OrderHasItem, Long> {
}