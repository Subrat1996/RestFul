package com.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SelectTestRunner implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public void run(String... args) throws Exception {

		String sql = "SELECT * FROM EMPLOYEE";
		EmployeeMapper mapper = new EmployeeMapper();

		List<Employee> list = jt.query(sql, mapper);
		for (Employee e : list) {
			System.out.println(e);
		}
	}

}
