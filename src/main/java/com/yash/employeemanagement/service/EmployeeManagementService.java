package com.yash.employeemanagement.service;

import com.yash.employeemanagement.entity.Employee;
import com.yash.employeemanagement.exceptionhandling.EmployeeNotPresentException;

public interface EmployeeManagementService {

	Employee insertEmployeeDetails(Employee employeeDetails);

	Employee getEmployeeDetails(int eid) throws EmployeeNotPresentException;

	Employee updateEmployeeDetails(Employee employeeDetails) throws EmployeeNotPresentException;

	String deleteEmployeeDetials(int eid);

}
