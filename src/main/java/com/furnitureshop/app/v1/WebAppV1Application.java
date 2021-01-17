package com.furnitureshop.app.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.furnitureshop"})
public class WebAppV1Application {

	public static void main(String[] args) {
		SpringApplication.run(WebAppV1Application.class, args);
	}

}
