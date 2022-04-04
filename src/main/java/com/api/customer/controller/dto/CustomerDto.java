package com.api.customer.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.customer.model.Customer;
import com.api.customer.util.ApiUtils;
	

public class CustomerDto {
	
	private Long documentId;
	
	private String name;
	
	private Integer age;
	
	private String registrationDate;
	
	private String lastUpdateInfo;
	
	private List<AdressDto> adress;
	
	
	/**
	 * @param customer {@link Customer}
	 */
	public CustomerDto(Customer customer) {
		this.documentId = customer.getDocumentId();
		this.name = customer.getName();
		this.age = customer.getAge();
		this.registrationDate = customer.getRegistrationDate().format(ApiUtils.formatter);
		this.lastUpdateInfo = customer.getLastUpdateInfo().format(ApiUtils.formatter);;
		this.adress = new ArrayList<AdressDto>();
		this.adress.addAll(customer.getAdress().stream().map(AdressDto::new).collect(Collectors.toList()));
	}
	
	
	/**
	 * @return the documentId
	 */
	public Long getDocumentId() {
		return documentId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * @return the registrationDate
	 */
	public String getRegistrationDate() {
		return registrationDate;
	}
	/**
	 * @return the lastUpdateInfo
	 */
	public String getLastUpdateInfo() {
		return lastUpdateInfo;
	}
	/**
	 * @return the listAdress
	 */
	public List<AdressDto> getAdress() {
		return adress;
	}
	
	public static List<CustomerDto> convertObject(List<Customer> customers) {
		return customers.stream().map(CustomerDto::new).collect(Collectors.toList());
	}
	

}
