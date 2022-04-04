package com.api.customer.form;

import com.api.customer.model.Adress;

public class AdressForm {
	
    /**
     * id from form request
     */
	private Long id;
	
    /**
     * zipCode from form request
     */
	private Integer zipCode;
	
    /**
     * numberAdress from form request
     */
	private Integer numberAdress;
	
	/**
	 * @param adress
	 */
	public AdressForm(Adress adress) {
		this.zipCode = adress.getZipCode();
		this.numberAdress = adress.getNumberAdress();
	}
	
	
	/**
	 * @param adress
	 * @param isEdit
	 */
	public AdressForm(Adress adress, boolean isEdit) {
		this.zipCode = adress.getZipCode();
		this.numberAdress = adress.getNumberAdress();
		this.id = adress.getId();
	}
	
	
	/**
	 * Default Constructor
	 */
	public AdressForm() {};

	/**
	 * @return the zipCode
	 */
	public Integer getZipCode() {
		return zipCode;
	}

	/**
	 * @return the numberAdress
	 */
	public Integer getNumberAdress() {
		return numberAdress;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
