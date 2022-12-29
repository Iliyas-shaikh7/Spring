package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService; 
	
	
	@RequestMapping("/")
	public String registration(){
		return "registratioin";
	}
	@RequestMapping(path = "/registrationProcess", method = RequestMethod.POST)
	public String registrationHandler(@ModelAttribute Employee emp, Model model){
		
		this.employeeService.createEmp(emp);
		return "profile";
	}
	@RequestMapping("/loginprocess")
	public String login(){
		
		return "login";
	}
	
	
	
}
