package com.journaldev.spring.services;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVo;

public interface EmployeeService {
	public Employee GetEmployees();
	public EmployeeVo GetallEmployees();
	public Employee GetEmpbyId(Long eid);
	public void DeleteEmpbyId(Long eid);
}
