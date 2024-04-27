package com.markcode.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringbatchCargadbApplication {

	public static void main(String[] args) {

			System.exit(
					SpringApplication.exit(
							SpringApplication.run(SpringbatchCargadbApplication.class, args)
					));


	}

}
