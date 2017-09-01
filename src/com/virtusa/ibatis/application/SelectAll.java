package com.virtusa.ibatis.application;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.virtusa.ibatis.entity.Employee;
import com.virtusa.ibatis.repository.EmployeeRepository;
import com.virtusa.ibatis.repository.EmployeeRepositoryImpl;

public class SelectAll {
	public static void main(String[] args) throws IOException, SQLException {

		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

		EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
		
		List<Employee> employeeList = (List<Employee>) employeeRepository.getAllEmployees(smc);
		for (Employee e : employeeList) {
			System.out.println(e.toString());
		}
	}
}
