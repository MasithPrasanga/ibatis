package com.virtusa.ibatis.repository;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.virtusa.ibatis.entity.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Override
	public Employee insert(Employee employee, SqlMapClient smc) {
		System.out.println("before saving the object");
		try {
			smc.insert("Employee.insert", employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees(SqlMapClient smc) {
		List<Employee> employeeList = null;
		try {
			employeeList = smc.queryForList("Employee.getAllEmployees", null);
			System.out.println("get all employee method size is : " + employeeList.size());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public Employee findById(int id, SqlMapClient smc) {

		Employee employee = null;
		try {
			employee = (Employee) smc.queryForObject("Employee.getById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee deleteById(int id, SqlMapClient smc) {
		Employee employee = null;
		try {
			employee = (Employee) smc.queryForObject("Employee.getById", id);
			smc.delete("Employee.deleteById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee update(Employee employee, SqlMapClient smc) {
		try {
			smc.update("Employee.update", employee);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

}
