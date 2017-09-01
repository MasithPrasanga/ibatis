package com.virtusa.ibatis.application;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.virtusa.ibatis.entity.Employee;
import com.virtusa.ibatis.repository.EmployeeRepository;
import com.virtusa.ibatis.repository.EmployeeRepositoryImpl;

public class Insert {

	public static void main(String[] args) throws IOException, SQLException {

		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		
		Employee employee = new Employee("java","james gosling",10000);
		
		EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
		employeeRepository.insert(employee,smc);
	}
}
