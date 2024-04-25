package com.xpertia.tec.ejemplo.SpringBootJdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.xpertia.tec.ejemplo.SpringBootJdbc.repository.IEmployeeRepository;


/**
 * The Class SpringBootJdbcTemplateApplication.
 */
@SpringBootApplication
public class SpringBootJdbcTemplateApplication {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootJdbcTemplateApplication.class);
	
	/** The repository. */
	@Qualifier("employeeRepository")
	private IEmployeeRepository repository;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LOGGER.info("Start SpringBootJdbcTemplateApplication ...  ");
		SpringApplication.run(SpringBootJdbcTemplateApplication.class, args);
	}

}
