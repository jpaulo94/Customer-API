package com.api.customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Optional<Customer> findByDocumentId(Long id);
	
	List<Customer> findByAdress_ZipCode(Integer zipCode);
	
	void deleteByDocumentId(Long id);

}
