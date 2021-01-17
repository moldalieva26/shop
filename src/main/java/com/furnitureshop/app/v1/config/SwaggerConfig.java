package com.furnitureshop.app.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	   @Bean
	   public Docket apiDocket() {
	       
	       Docket docket =  new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.furnitureshop.app.v1.controller")) //?
	                .paths(PathSelectors.any())
	                .build();
	       
	       return docket;
	       
	    } 
	   // to open awagger on web: http://localhost:8090/v2/api-docs
	   // or http://localhost:8090/swagger-ui.html for ui friendly 
	   // https://www.appsdeveloperblog.com/add-swagger-to-spring-boot-project/ for more info

}
