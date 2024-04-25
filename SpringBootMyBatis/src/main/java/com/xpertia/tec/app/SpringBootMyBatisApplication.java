package com.xpertia.tec.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class SpringBootMyBatisApplication.
 */
@SpringBootApplication
public class SpringBootMyBatisApplication {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootMyBatisApplication.class);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		LOGGER.info("Start SpringBootMyBatisApplication ...  ");
		SpringApplication.run(SpringBootMyBatisApplication.class, args);
	}
	


}
