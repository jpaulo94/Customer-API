/**
 * 
 */
package com.api.customer.form;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.api.customer.model.Adress;
import com.api.customer.model.Customer;


public class CustomerForm implements Serializable{
	
	private static final long serialVersionUID = -9219476308509132983L;
	
    /**
     * Name from form request
     */
	@NotNull @NotEmpty
	private String name;
	
    /**
     * Age from form request
     */
	@NotNull
	private Integer age;
	
	/**
     * List<AdressForm> from form request
     */
	private List<AdressForm> adressForm;
	
	
    /**
     * List<Adress> model for dto
     */
	private List<Adress> adressListModel;

	
	/**
	 * @return a new Customer
	 */
	public Customer setFormFields() {
		setAdressFields(null, Boolean.FALSE);
		return new Customer(this.name, this.age, adressListModel);
	}

	/**
	 * @param customer
	 * @param isEdit 
	 */
	private void setAdressFields(Customer customer, boolean isEdit) {
		if (null != adressForm) {
			adressListModel = new ArrayList<Adress>();
			
			adressForm.forEach(e -> {
				Adress adressModel = isEdit 
						?  new Adress(e.getZipCode(),  e.getNumberAdress(), customer.getDocumentId(), e.getId())  
								:  new Adress(e.getZipCode(),  e.getNumberAdress());
				adressListModel.add(adressModel);
			});
		}
	}
	
	/**
	 * @param customer
	 * @param adressService 
	 * @return a customer edited
	 */
	public Customer updateCostumer(Customer customer) {

		customer.setName(this.getName());
		customer.setAge(this.getAge());
		customer.setLastUpdateInfo(LocalDateTime.now());		
		
		setAdressFields(customer, Boolean.TRUE);
		customer.setAdress(this.adressListModel);
		return customer;
	}
	
	
	public CustomerForm() {};

	/**
	 * @return the adressForm
	 */
	public List<AdressForm> getAdressForm() {
		return adressForm;
	}


	/**
	 * @param adressForm the adressForm to set
	 */
	public void setAdressForm(List<AdressForm> adressForm) {
		this.adressForm = adressForm;
	}


	/**
	 * @return the adressListModel
	 */
	public List<Adress> getAdressListModel() {
		return adressListModel;
	}


	/**
	 * @param adressListModel the adressListModel to set
	 */
	public void setAdressListModel(List<Adress> adressListModel) {
		this.adressListModel = adressListModel;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
}
