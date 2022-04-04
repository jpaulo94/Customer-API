/**
 * 
 */
package com.api.customer.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentId;
	
	private String name;
	
	private Integer age;
	
	private LocalDateTime registrationDate;
	
	private LocalDateTime lastUpdateInfo;
	
	@OneToMany(mappedBy="documentId")
	private List<Adress> adress;
	
	public Customer() {};
	

	/**
	 * @param name
	 * @param age
	 * @param documentId
	 * @param adress
	 */
	public Customer(String name, Integer age, List<Adress> adress) {
		this.name = name;
		this.age = age;
		this.registrationDate = LocalDateTime.now();
		this.lastUpdateInfo = LocalDateTime.now();
		this.adress = adress;
	}
	
	/**
	 * @param name
	 * @param age
	 * @param documentId
	 * @param adress
	 */
	public Customer(String name, Integer age, List<Adress> adress, boolean isEdit) {
		this.name = name;
		this.age = age;
		this.lastUpdateInfo = LocalDateTime.now();
		this.adress = adress;
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

	/**
	 * @return the registrationDate
	 */
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the lastUpdateInfo
	 */
	public LocalDateTime getLastUpdateInfo() {
		return lastUpdateInfo;
	}

	/**
	 * @param lastUpdateInfo the lastUpdateInfo to set
	 */
	public void setLastUpdateInfo(LocalDateTime lastUpdateInfo) {
		this.lastUpdateInfo = lastUpdateInfo;
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

	/**
	 * @return the adress
	 */
	public List<Adress> getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(List<Adress> adress) {
		this.adress = adress;
	}
}
