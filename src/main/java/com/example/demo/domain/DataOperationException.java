package com.example.demo.domain;

public class DataOperationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7126423000088946233L;
	public DataOperationException(String errorMessage) {
		super(errorMessage);
	}
	public DataOperationException(String errorMessage, Throwable err) {
		super(errorMessage,err);
	}
}
