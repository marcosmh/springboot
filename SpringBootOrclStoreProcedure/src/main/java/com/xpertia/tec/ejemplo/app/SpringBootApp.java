package com.xpertia.tec.ejemplo.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootApp {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootApp.class);

	public static void main(String[] args) {
		LOGGER.info("Start SpringBootApp ...  ");
		LOGGER.info("Procedimientos Almacenados con Oracle ...  ");
		SpringApplication.run(SpringBootApp.class, args);
	}

}
