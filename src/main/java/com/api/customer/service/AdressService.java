/**
 * 
 */
package com.api.customer.service;

import com.api.customer.model.Adress;
import com.api.customer.model.Customer;

public interface AdressService {

	void addAdress(Customer customer);
	
	Adress findById(Long id, Adress adressObj);

}
