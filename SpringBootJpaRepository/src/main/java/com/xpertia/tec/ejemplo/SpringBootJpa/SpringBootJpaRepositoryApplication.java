package com.xpertia.tec.ejemplo.SpringBootJpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class SpringBootJpaRepositoryApplication.
 */
@SpringBootApplication
public class SpringBootJpaRepositoryApplication {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootJpaRepositoryApplication.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LOGGER.info("Start SpringBootJpaRepositoryApplication ...  ");
		SpringApplication.run(SpringBootJpaRepositoryApplication.class, args);
	}

}
