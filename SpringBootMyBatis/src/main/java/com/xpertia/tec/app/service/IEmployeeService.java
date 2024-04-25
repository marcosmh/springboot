package com.xpertia.tec.app.service;

import java.util.List;

import com.xpertia.tec.app.model.Employee;

/**
 * The Interface IEmployeeService.
 */
public interface IEmployeeService {

	/**
	 * Find all.
	 * @return the list
	 */
	List<Employee> findAll();
	
	/**
	 * Find by id.
	 * @param id the id
	 * @return the employee
	 */
	Employee findById(Long id);
	
	/**
	 * Save.
	 *
	 * @param employee the employee
	 * @return the long
	 */
	Long save(Employee employee);
	
	/**
	 * Update.
	 *
	 * @param employee the employee
	 * @return the long
	 */
	Long update(Employee employee);
	
	/**
	 * Delete by id.
	 * @param id the id
	 */
	void deleteById(Long id);
}
