package com.api.customer.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.customer.model.Adress;
import com.api.customer.model.Customer;
import com.api.customer.repository.AdressRepository;
import com.api.customer.service.AdressService;


@Service
public class AdressServiceImpl implements AdressService{
	
	@Autowired
	AdressRepository adressRepository;

	@Override
	public void addAdress(Customer customer) {
		 this.setAdressObject(customer);
	}
	
	@Transactional
	private List<Adress> saveAllAdress(List<Adress> adressList) {
		return (List<Adress>) adressRepository.saveAll(adressList);
	}


	private void setAdressObject(Customer customer) {
		List<Adress> listAdressCustomer = customer.getAdress();
		
		listAdressCustomer.forEach(listEach -> {
			listEach.setDocumentId(customer.getDocumentId());
		});
		
		this.saveAllAdress(listAdressCustomer);
	}

	@Override
	public Adress findById(Long id, Adress adressObj) {
		 Optional<Adress> listOpt = adressRepository.findById(id);
		 if (listOpt.isPresent()) {
			 adressRepository.save(adressObj);
		 }
		 
		return adressObj;

	}

}
