package com.xpertia.tec.ejemplo.SpringBootJdbc.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xpertia.tec.ejemplo.SpringBootJdbc.model.Employee;
import com.xpertia.tec.ejemplo.SpringBootJdbc.repository.IEmployeeRepository;

/**
 * The Class EmployeeService.
 */
@Service
public class EmployeeService implements IEmployeeService {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	/** The repository. */
	@Autowired
	private IEmployeeRepository repository;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@Override
	public List<Employee> findAll() {
		LOGGER.info("Buscar Todos los Empleados");
		return repository.findAll();
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	@Override
	public Employee findById(Long id) {
		LOGGER.info("Buscar Empleado por id: " +  id);
		return repository.findById(id);
	}

	/**
	 * Count.
	 *
	 * @return the int
	 */
	@Override
	public int count() {
		LOGGER.info("Contar los Empleados");
		return repository.count();
	}

	/**
	 * Save.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	@Override
	public int save(Employee employee) {
		LOGGER.info("Guardar Empleado");
		return repository.save(employee);
	}

	/**
	 * Update.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	@Override
	public int update(Employee employee) {
		LOGGER.info("Actualizar Empleado");		
		return repository.update(employee);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the int
	 */
	@Override
	public int deleteById(Long id) {
		LOGGER.info("Borrar Empleado por id: " +  id);
		return repository.deleteById(id);
	}

}
