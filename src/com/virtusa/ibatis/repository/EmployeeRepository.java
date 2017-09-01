package com.virtusa.ibatis.repository;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.virtusa.ibatis.entity.Employee;

public interface EmployeeRepository {
	
	public Employee insert(Employee employee,SqlMapClient smc);
	
	public List<Employee> getAllEmployees(SqlMapClient smc);
	
	public Employee findById(int id,SqlMapClient smc);

	public Employee deleteById(int id, SqlMapClient smc);

	public Employee update(Employee employee, SqlMapClient smc);
	
}
