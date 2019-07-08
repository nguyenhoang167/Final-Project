package vn.edu.vnuk.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnuk.ecommerce.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}