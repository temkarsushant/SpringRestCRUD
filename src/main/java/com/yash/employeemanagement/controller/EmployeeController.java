package com.yash.employeemanagement.controller;

import com.yash.employeemanagement.entity.Employee;
import com.yash.employeemanagement.exceptionhandling.EmployeeNotPresentException;
import com.yash.employeemanagement.service.EmployeeManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeManagementService employeeManagementService;

//	@GetMapping("/test")
//	private String testServer() {
//		return "Hello";
//	}

	@PostMapping("/saveemployeedetails")
	public ResponseEntity<Employee> insertEmployeeDetails(@RequestBody Employee employeeDetails) {

		Employee employee = employeeManagementService.insertEmployeeDetails(employeeDetails);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/getemployeeeetails")
	public ResponseEntity<Employee> getEmployeeDetails(@RequestParam("eid") int eid)
			throws EmployeeNotPresentException {

		Employee employee = employeeManagementService.getEmployeeDetails(eid);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PutMapping("/updateemployeeeetails")
	public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employeeDetails)
			throws EmployeeNotPresentException {
		Employee employee = employeeManagementService.updateEmployeeDetails(employeeDetails);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/deleteemployeedetails/{eid}")
	public ResponseEntity<String> delateEmployeDetails(@PathVariable int eid) {

		String result = null;
		result = employeeManagementService.deleteEmployeeDetials(eid);

		return new ResponseEntity<>(result, HttpStatus.OK);

	}

}
