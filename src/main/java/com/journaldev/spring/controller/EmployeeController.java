package com.journaldev.spring.controller;

import java.lang.annotation.Repeatable;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.RespectBinding;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVo;
import com.journaldev.spring.services.EmployeeService;

//import com.journaldev.spring.model.Employee;
@Controller
public class EmployeeController {
	
	@Autowired
	@Qualifier(value="employeeServiceImpl")
	EmployeeService service;
	
	@Autowired
	SessionFactory sf;
	
	@RequestMapping(value ="/rest/emp/insert",method=RequestMethod.GET)
	public @ResponseBody String insertEmployee()
	{
		service.InsertEmployee();
		return "done";
	}
	
	
	@RequestMapping(value ="/rest/emp/dummy",method=RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee()
	{
		Employee emp =service.GetEmployees();
		return emp;
	}
	
	@RequestMapping(value ="/rest/emp/list",method=RequestMethod.GET)
	public @ResponseBody EmployeeVo getAllEmployee()
	{
		EmployeeVo emp1 = service.GetallEmployees();
		
		return emp1;
	}
	
	@RequestMapping(value ="/rest/emp/{id}",method=RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") long empId)
	{
		Employee emp= service.GetEmpbyId(empId);
		return emp;
		
	}

	@RequestMapping(value ="/rest/deleteemp/{id}",method=RequestMethod.GET)
	public @ResponseBody String deleteEmployee(@PathVariable("id") long empId)
	{
		service.DeleteEmpbyId(empId);
		return "done";
	}
}
