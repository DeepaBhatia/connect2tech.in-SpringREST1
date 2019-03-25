package com.c2t.spring.dao;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.EmployeeVo;

public interface EmployeeDAO {
	
	public Employee GetEmployee();
	public EmployeeVo GetAllEmployee();
	public Employee GetById(Long eid);
	public void DeleteById(Long eid);

}
