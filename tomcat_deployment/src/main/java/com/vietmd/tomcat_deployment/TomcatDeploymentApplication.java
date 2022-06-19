package com.vietmd.tomcat_deployment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TomcatDeploymentApplication extends SpringBootServletInitializer {
	//We need to extend the class SpringBootServletInitializer to support WAR file deployment

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(TomcatDeploymentApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TomcatDeploymentApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String Hello(){
		return "Hello World from Tomcat";
	}

	@Value("${spring.application.name}")
	private String name;

	@RequestMapping(value = "/name")
	public String name(){
		return name;
	}

}
