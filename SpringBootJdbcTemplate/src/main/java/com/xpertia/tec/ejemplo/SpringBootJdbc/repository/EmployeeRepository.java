package com.xpertia.tec.ejemplo.SpringBootJdbc.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.xpertia.tec.ejemplo.SpringBootJdbc.model.Employee;

/**
 * The Class EmployeeRepository.
 */
@Repository
public class EmployeeRepository implements IEmployeeRepository {

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("select id,first_name as firstName,last_name as lastName,email_address as emailAddress from employees ", 
				(data,rowNum) -> new Employee(data.getLong("id"),
									            data.getString("firstName"),
									            data.getString("lastName"),
									            data.getString("emailAddress")));
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	@Override
	public Employee findById(Long id) {
		return jdbcTemplate.queryForObject(" select id,first_name as firstName,last_name as lastName, "
				+ " email_address as emailAddress from employees where id = ?  ",new Object[]{id}, 
				(data,rowNum) -> new Employee(data.getLong("id"),
			                                  data.getString("firstName"),
			                                  data.getString("lastName"),
			                                  data.getString("emailAddress")));
	}

	/**
	 * Count.
	 *
	 * @return the int
	 */
	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(id) as total from employees ", Integer.class);
	}

	/**
	 * Save.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	@Override
	public int save(Employee employee) {
		return jdbcTemplate.update("insert into employees(id,first_name,last_name,email_address) values(?,?,?,?) ",
				employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmailAddress());
	}

	/**
	 * Update.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	@Override
	public int update(Employee employee) {
		return jdbcTemplate.update("update employees set first_name = ?,last_name = ?, email_address = ? where id = ? ",
				employee.getFirstName(),employee.getLastName(),employee.getEmailAddress(),employee.getId());
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the int
	 */
	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update("delete from employees where id = ? ",id);
	}

}
