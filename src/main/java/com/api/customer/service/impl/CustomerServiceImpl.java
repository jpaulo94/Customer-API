/**
 * 
 */
package com.api.customer.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.customer.model.Customer;
import com.api.customer.repository.CustomerRepository;
import com.api.customer.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomers(Integer zipCode) {
		
		List<Customer> customers = zipCode == null 
				? customerRepository.findAll() 
				: customerRepository.findByAdress_ZipCode(zipCode);
		
		return customers;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	@Transactional
	public Boolean findByDocumentId(Long id) {
		Optional<Customer> optional = customerRepository.findByDocumentId(id);
		
		if (optional.isPresent()) {
			this.deleteByDocumentId(id);
			return Boolean.TRUE;
			}
		
		return Boolean.FALSE;
	}
	
	
	@Override
	@Transactional
	public Optional<Customer> findByDocumentId(Long id, Boolean isRemove) {
		return customerRepository.findByDocumentId(id);
	}

	@Override
	@Transactional
	public void deleteByDocumentId(Long id) {
		 customerRepository.deleteByDocumentId(id);
	}

}
