package org.webonise.springboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.webonise.springboot.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(Long id);
}
