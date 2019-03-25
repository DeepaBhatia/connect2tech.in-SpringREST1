package com.journaldev.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVo;
import com.c2t.spring.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	@Qualifier(value="employeeDAOImpl")
	EmployeeDAO empdao;
	
	
	public Employee GetEmployees()
	{
		
		Employee emp = empdao.GetEmployee();
		return emp;
	}
	public EmployeeVo GetallEmployees()
	{
		EmployeeVo emp = empdao.GetAllEmployee();
		return emp;
	}
	public Employee GetEmpbyId(Long eid) {
		Employee emp = empdao.GetById(eid);
		return emp;
	}
	public void DeleteEmpbyId(Long eid) {
		empdao.DeleteById(eid);
	}

}
