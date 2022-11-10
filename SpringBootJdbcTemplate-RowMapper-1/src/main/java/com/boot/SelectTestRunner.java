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
		
		//EmployeeMapper mapper = new EmployeeMapper();
		// String sql = "SELECT * FROM EMPLOYEE";
		// List<Employee> list = jt.query(sql, mapper);

		//String sql = "SELECT * FROM EMPLOYEE WHERE ID>=?";
		//List<Employee> list = jt.query(sql, mapper, 2);
		
		/*
		 * String sql = "SELECT * FROM EMPLOYEE WHERE ID=?"; List<Employee> list =
		 * jt.query(sql, mapper, 3);
		 */
		
		
		/*
		 * for (Employee e : list) { System.out.println(e); }
		 */
		/*
		 * String sql = "SELECT * FROM EMPLOYEE WHERE ID=?"; Employee e =
		 * jt.queryForObject(sql, mapper,2); 
		 * Student sob=jt.queryForObject(sql,
				(rs,count)->new Student(rs.getInt("SID"),
						rs.getString("SNAME"),rs.getDouble("SFEE"))
		,"CD");
		 */
		String sql = "SELECT * FROM EMPLOYEE WHERE ID=?";
	     Employee eob=jt.queryForObject(sql,
	    		 (rs,rownum)->new Employee(rs.getInt("id"),
	    		 rs.getString("name"),rs.getDouble("sal")),2);
	     System.out.println(eob);
	}

}
