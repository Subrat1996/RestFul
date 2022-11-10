package com.boot.config;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select() //select all restcontrollers
				.apis(basePackage("in.nit.controller")) //inside package
				.paths(regex("/rest.*")) //starting path
				.build()
				.apiInfo(apiInfo()); //create UI
	}

	public ApiInfo apiInfo() {
		return new ApiInfo("STUDENTS APP", 
				"WLCOME TO MY APP", "1.3.6", "http://nareshit.in", 
				new Contact("RAGHU", "http://nareshit.in", 
				"javabyraghu@gmail.com"), "Naresh IT Licence", "http://nareshit.in", new ArrayList<>());
	}
}
