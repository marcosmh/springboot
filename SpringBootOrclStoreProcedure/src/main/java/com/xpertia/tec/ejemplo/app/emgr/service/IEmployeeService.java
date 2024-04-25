package com.xpertia.tec.ejemplo.app.emgr.service;

import java.util.List;

import com.xpertia.tec.ejemplo.app.emgr.model.Employee;

/**
 * The Interface IEmployeeService.
 */
public interface IEmployeeService {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Employee> findAll();
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	Employee findById(Long id);
	
	/**
	 * Count.
	 *
	 * @return the int
	 */
	int count();
	
	/**
	 * Save.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	int save(Employee employee);
	
	/**
	 * Update.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	int update(Employee employee);
	
	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the int
	 */
	int deleteById(Long id);
}
