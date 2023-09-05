package com.crud.java.utils;

import org.springframework.http.HttpStatus;

public class BaseResponse<T> {
    private boolean success;
    private String message;
    private Object data;
    private HttpStatus status;
	public boolean isSuccess() {
		return success;
	}
	
	public BaseResponse(boolean success, String message, Object data, HttpStatus status) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
		this.status = status;
	}



	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

    
}
