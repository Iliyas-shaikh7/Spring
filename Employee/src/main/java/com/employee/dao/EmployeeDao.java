package com.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public int saveEmp(Employee emp){
		int id = (Integer)this.hibernateTemplate.save(emp);
		return id;
	}
}
