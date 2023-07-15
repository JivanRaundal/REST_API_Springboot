package com.psl.training.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Hello REST API")
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHelloMsg() {
		return "Hello World!";
	}
}
