package com.virtusa.ibatis.application;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.virtusa.ibatis.entity.Employee;
import com.virtusa.ibatis.repository.EmployeeRepository;
import com.virtusa.ibatis.repository.EmployeeRepositoryImpl;

public class DeleteById {

	public static void main(String[] args) throws IOException {

		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

		EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

		Employee employee = employeeRepository.deleteById(4, smc);

		System.out.println("------------delete by id -------------------------------");
		System.out.println("deleted employee : "+employee.toString());

		System.out.println("-------------------------------------------------------");

	}
}
