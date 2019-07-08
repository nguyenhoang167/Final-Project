package vn.edu.vnuk.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnuk.ecommerce.model.OrderAddress;

@Repository
public interface OrderAddressRepository extends CrudRepository<OrderAddress, Long> {

    Page<OrderAddress> findAllByAccontId(Long accountId, Pageable pageable);
}