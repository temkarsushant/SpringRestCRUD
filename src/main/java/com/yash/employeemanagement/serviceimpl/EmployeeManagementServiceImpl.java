package com.yash.employeemanagement.serviceimpl;

import java.util.Optional;

import com.yash.employeemanagement.entity.Employee;
import com.yash.employeemanagement.exceptionhandling.EmployeeNotPresentException;
import com.yash.employeemanagement.repository.EmployeeManagementRepository;
import com.yash.employeemanagement.service.EmployeeManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	@Autowired
	EmployeeManagementRepository employeeManagementRepository;

	@Override
	public Employee insertEmployeeDetails(Employee employeeDetails) {
		return employeeManagementRepository.save(employeeDetails);
	}

	@Override
	public Employee getEmployeeDetails(int eid) throws EmployeeNotPresentException {

		Optional<Employee> employee = employeeManagementRepository.findById(eid);
		System.out.println(employee);

		if (employee.isEmpty()) {
			throw new EmployeeNotPresentException("Requested Employee details not found.");
		}

		return employee.get();
	}

	@Override
	public Employee updateEmployeeDetails(Employee employeeDetails) throws EmployeeNotPresentException {
		getEmployeeDetails(employeeDetails.getEid());
		Employee employee = employeeManagementRepository.save(employeeDetails);
		return employee;
	}

	@Override
	public String deleteEmployeeDetials(int eid) {
		String result = null;
		try {
			getEmployeeDetails(eid);
			employeeManagementRepository.deleteById(eid);
			result = "Record Deleted Successfully";
		} catch (Exception e) {
			result = "Error while deleting record.";
		}
		return result;
	}

}
