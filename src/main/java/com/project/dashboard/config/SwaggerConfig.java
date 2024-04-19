package com.project.dashboard.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
	Contact contact=new Contact("Priyanka Pandharbale", null, "pandharbalepr1997@gmail.com");
		

	List<VendorExtension> extensions=new ArrayList<>();
		
		
		ApiInfo apiInfo=new ApiInfo("Dashboard", 
				"This is a Dashboard Api "
				+"Built Using Spring Boot, It is completely restful ,"
				+ "Built using rest Technology", 
				"1.0 first", "", contact, "", "", extensions);
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.project.dashboard.controller"))
				.paths(PathSelectors.any())
				.build();
	}
}
