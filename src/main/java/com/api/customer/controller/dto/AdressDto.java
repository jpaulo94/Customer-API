package com.api.customer.controller.dto;

import com.api.customer.model.Adress;
import com.api.customer.util.ApiUtils;

public class AdressDto {
	
	private Long id;
	
	private String zipCode;
	
	private Integer numberAdress;
	
	/**
	 * @param zipCode
	 * @param numberAdress
	 */
	public AdressDto(Adress adress) {
		this.id = adress.getId();
		this.zipCode = String.valueOf(adress.getZipCode());
		this.numberAdress = adress.getNumberAdress();
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return ApiUtils.applyMask(zipCode, ApiUtils.MASK_ZIP_CODE);
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
