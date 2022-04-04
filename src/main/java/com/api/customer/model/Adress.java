/**
 * 
 */
package com.api.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.api.customer.controller.dto.AdressDto;


@Entity()
public class Adress {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "document_id")
	private Long documentId;
	
	private Integer zipCode;
	
	private Integer numberAdress;

	
	public Adress() {}


	/**
	 * @param zipCode
	 * @param numberAdress
	 */
	public Adress(Integer zipCode, Integer numberAdress) {
		this.zipCode = zipCode;
		this.numberAdress = numberAdress;
	}
	
	/**
	 * @param zipCode
	 * @param numberAdress
	 * @param id
	 */
	public Adress(Integer zipCode, Integer numberAdress, Long documentId, Long id) {
		this.id = id;
		this.zipCode = zipCode;
		this.numberAdress = numberAdress;
		this.documentId = documentId;
	}
	
	/**
	 * @param adressDto
	 */
	public Adress(AdressDto adressDto) {
		this.zipCode = Integer.valueOf(adressDto.getZipCode());
		this.numberAdress = adressDto.getNumberAdress();
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


	/**
	 * @return the zipCode
	 */
	public Integer getZipCode() {
		return zipCode;
	}


	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}


	/**
	 * @return the numberAdress
	 */
	public Integer getNumberAdress() {
		return numberAdress;
	}


	/**
	 * @param numberAdress the numberAdress to set
	 */
	public void setNumberAdress(Integer numberAdress) {
		this.numberAdress = numberAdress;
	}


	/**
	 * @return the documentId
	 */
	public Long getDocumentId() {
		return documentId;
	}


	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}


	
}
