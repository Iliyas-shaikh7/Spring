package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

@Component
public class EmployeeService {

	@Autowired	
	private EmployeeDao employeeDao;
	
	public int createEmp(Employee emp){
		return this.employeeDao.saveEmp(emp);
	}
}
