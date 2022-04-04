package com.api.customer.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.customer.controller.dto.CustomerDto;
import com.api.customer.form.CustomerForm;
import com.api.customer.model.Customer;
import com.api.customer.service.impl.AdressServiceImpl;
import com.api.customer.service.impl.CustomerServiceImpl;
import com.api.customer.util.ApiUtils;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerService;

	@Autowired
	AdressServiceImpl adressService;

	@GetMapping("/search")
	public ResponseEntity<List<CustomerDto>> getCustomers(Integer zipCode) {
		
		try {
			List<Customer> customers = customerService.getCustomers(zipCode);
			
			if (customers.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ApiUtils.LIST_NOT_FOUND);
			}

			return ResponseEntity.ok(CustomerDto.convertObject(customers));

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@PostMapping("/add")
	@Transactional
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody @Valid CustomerForm form,
			UriComponentsBuilder uriBuilder) {

		try {
			Customer customer = form.setFormFields();
			customerService.addCustomer(customer);
			adressService.addAdress(customer);

			URI uri = uriBuilder.path("/customer/{documentId}").buildAndExpand(customer.getDocumentId()).toUri();
			return ResponseEntity.created(uri).body(new CustomerDto(customer));

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/remove/{id}")
	@Transactional
	public ResponseEntity<?> removeCustomer(@PathVariable Long id) {

		try {

			if (customerService.findByDocumentId(id)) {
				return ResponseEntity.ok().build();
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ApiUtils.MSG_ID_CUSTOMER_NOT_FOUND);
			}

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	@PutMapping("/edit/{id}")
	@Transactional
	public ResponseEntity<CustomerDto> editCustomer(@PathVariable Long id, @RequestBody @Valid CustomerForm form) {

		try {
			Optional<Customer> customerOpt = customerService.findByDocumentId(id, Boolean.FALSE);
			Customer customer = form.updateCostumer(customerOpt.get());
			
			customer.getAdress().forEach(adressObj -> {
				adressService.findById(adressObj.getId(), adressObj);
			});
			
			return ResponseEntity.ok(new CustomerDto(customer));


		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ApiUtils.MSG_ERROR_EDIT_CUSTOMER);
		}
	}
}
