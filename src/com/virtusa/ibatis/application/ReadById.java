package com.virtusa.ibatis.application;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.virtusa.ibatis.entity.Employee;
import com.virtusa.ibatis.repository.EmployeeRepository;
import com.virtusa.ibatis.repository.EmployeeRepositoryImpl;

public class ReadById {
	public static void main(String[] args) throws IOException {
		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		
		EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
		
		Employee employee = employeeRepository.findById(4, smc);
		
		System.out.println("------------read by id -------------------------------");
		
		System.out.println(employee.toString());
		
		
		System.out.println("-------------------------------------------------------");
	}
}
