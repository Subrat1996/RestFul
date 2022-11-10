package in.boot.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.boot.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	
}
