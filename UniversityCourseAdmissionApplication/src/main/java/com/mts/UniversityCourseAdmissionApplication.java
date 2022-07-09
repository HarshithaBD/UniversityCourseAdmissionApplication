package com.mts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.modelmapper.ModelMapper;
@EnableSwagger2
@SpringBootApplication
public class UniversityCourseAdmissionApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(UniversityCourseAdmissionApplication.class, args);


		System.out.println("connected to database");
	}
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
           .apis(RequestHandlerSelectors.basePackage("com.mts")).build();
     }

}
