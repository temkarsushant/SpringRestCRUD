package com.yash.employeemanagement.exceptionhandling;

public class EmployeeNotPresentException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 6108462009803754601L;

	public EmployeeNotPresentException(String str) {
		super(str);
	}

}
