package com.xpertia.tec.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpertia.tec.app.model.Employee;
import com.xpertia.tec.app.service.IEmployeeService;

/**
 * The Class EmployeeController.
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	/** The service. */
	@Autowired
	private IEmployeeService service;
	
	/**
	 * Consultar empleados.
	 * @return the response entity
	 */
	@GetMapping
	public ResponseEntity<List<Employee>> consultarEmpleados() {		
		LOGGER.info("Peticion recibida para consultar los empleados");
		return new ResponseEntity<List<Employee>>(service.findAll(),HttpStatus.OK);		
	}
	
	/**
	 * Consultar empleado por id.
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Employee> consultarEmpleadoPorId(@PathVariable("id") Long id) {
		LOGGER.info("Peticion recibida para consultar empleado por id: " +  id);
		return new ResponseEntity<Employee>(service.findById(id),HttpStatus.OK);		
	}
	
	/**
	 * Guardar empleado.
	 * @param employee the employee
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Long> guardarEmpleado(@RequestBody Employee employee) {
		LOGGER.info("Peticion recibida para guardar Empleado");
		return new ResponseEntity<Long>(service.save(employee),HttpStatus.OK);
	}
	
	/**
	 * Actualizar empleado.
	 * @param employee the employee
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<Long> actualizarEmpleado(@RequestBody Employee employee) {
		LOGGER.info("Peticion recibida para actualizar empleado");
		return new ResponseEntity<Long>(service.update(employee),HttpStatus.OK);
	}
	
	/**
	 * Borrar empleado por id.
	 * @param id the id
	 */
	@DeleteMapping("/{id}")
	public void borrarEmpleadoPorId(@PathVariable("id") Long id) {
		LOGGER.info("Peticion recibida para borrar Empleado por id: " +  id);
		service.deleteById(id);
	}
	
}
