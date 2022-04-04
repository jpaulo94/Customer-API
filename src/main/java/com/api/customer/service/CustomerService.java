package com.api.customer.service;

import java.util.List;
import java.util.Optional;

import com.api.customer.model.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers(Integer zipCode);
	
	Customer addCustomer(Customer customer);

	void deleteByDocumentId(Long id);

	Optional<Customer> findByDocumentId(Long id, Boolean isRemove);

	Boolean findByDocumentId(Long id);

}
