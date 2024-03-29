package com.c2t.spring.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c2t.annotation.basic.Employee;
import com.c2t.annotation.basic.Employee2;
import com.c2t.annotation.basic.EmployeeVo;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	@Autowired
	SessionFactory sf;

	@Override
	public Employee GetEmployee() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Employee emp =(Employee)s.get(Employee.class,1l);
		System.out.println(emp.getCellphone());
		System.out.println(emp.getId());
		System.out.println(emp.getFirstname());
		return emp;
	}

	@Override
	public EmployeeVo GetAllEmployee() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Query q = s.createQuery("from Employee");
		List<Employee> emp = q.list();
		
		EmployeeVo emp1 = new EmployeeVo();
		emp1.setEmployees(emp);
		return emp1;
	}

	@Override
	public Employee GetById(Long eid) {
		// TODO Auto-generated method stub
		
		Session s  = sf.openSession();
		Employee emp =(Employee)s.get(Employee.class,eid);
		return emp;
	}

	@Override
	public void DeleteById(Long eid) {
		// TODO Auto-generated method stub
		Session s  = sf.openSession();
		Employee emp =(Employee)s.get(Employee.class,eid);
		s.delete(emp);
		s.beginTransaction().commit();
	}

	@Override
	public void addEmployee() {
		// TODO Auto-generated method stub
		Session s = sf.openSession();
		Employee emp = new Employee("Samree", "kazi",new Date(1997/05/10), "788648");
		Employee2 emp1 = new Employee2("Samree", "kazi",new Date(1997/05/10), "788648");
		s.beginTransaction();
		s.save(emp);
		s.save(emp1);
		s.beginTransaction().commit();
		
	}

}
