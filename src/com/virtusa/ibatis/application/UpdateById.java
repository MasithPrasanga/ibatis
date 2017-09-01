package com.virtusa.ibatis.application;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.virtusa.ibatis.entity.Employee;
import com.virtusa.ibatis.repository.EmployeeRepository;
import com.virtusa.ibatis.repository.EmployeeRepositoryImpl;

public class UpdateById {
	public static void main(String[] args) throws IOException {
		
		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

		EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

		int id = 10;
		Employee employee = employeeRepository.findById(id, smc);
		
		employee.setFirstName("masith");
		employee.setLastName("prasanga");
		employee.setSalary(1000000);
		
		Employee e = null;
		e = employeeRepository.update(employee, smc);

		System.out.println("------------update by id -------------------------------");

		System.out.println(e.toString());

		System.out.println("-------------------------------------------------------");
	}
}


