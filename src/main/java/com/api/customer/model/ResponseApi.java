package com.api.customer.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ResponseApi implements Serializable{

	private static final long serialVersionUID = -8383105205224728960L;
	
	private String message;
	
	private Integer code;
	
	private LocalDateTime timeRequest = LocalDateTime.now();
	
	/**
	 * @param message
	 * @param code
	 */
	public ResponseApi(String message, Integer code) {
		this.message = message;
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @return the timeRequest
	 */
	public LocalDateTime getTimeRequest() {
		return timeRequest;
	}

	/**
	 * @param timeRequest the timeRequest to set
	 */
	public void setTimeRequest(LocalDateTime timeRequest) {
		this.timeRequest = timeRequest;
	}
	

}
