package com.yash.employeemanagement.repository;

import com.yash.employeemanagement.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeManagementRepository extends JpaRepository<Employee, Integer> {

}
