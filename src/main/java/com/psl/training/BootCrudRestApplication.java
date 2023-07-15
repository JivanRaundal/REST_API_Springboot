package com.psl.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info =@Info(title="Employee CRUD REST API", version="1.0", description="Sample API"))
public class BootCrudRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCrudRestApplication.class, args);
	}

}
