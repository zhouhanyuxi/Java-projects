package com.ncu.clothwholesale.tool;

public class MyServiceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7263771776317549649L;

	public MyServiceException(String message){
		super(message);
		this.message = message;
	}

	//异常信息
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
