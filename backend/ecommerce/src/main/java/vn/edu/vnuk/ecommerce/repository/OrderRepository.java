package vn.edu.vnuk.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnuk.ecommerce.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}