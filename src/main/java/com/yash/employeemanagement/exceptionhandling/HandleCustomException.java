package com.yash.employeemanagement.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleCustomException {
	private static final long serialVersionUID = 6737491281265570478L;

	@ExceptionHandler(EmployeeNotPresentException.class)
	public ResponseEntity<ExceptionResponseModel> handleEmployeeNotPresentException(EmployeeNotPresentException ex) {
		ExceptionResponseModel response = new ExceptionResponseModel();
		response.setMessage(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
