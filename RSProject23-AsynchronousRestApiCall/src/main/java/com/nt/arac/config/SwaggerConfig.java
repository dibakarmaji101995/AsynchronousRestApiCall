package com.nt.arac.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
     
	public Docket getDocketObject() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.nt.arac.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	public ApiInfo apiInfo() {
		return new ApiInfo("Spring Boot Rest Api",
				"Spring Boot Rest Api for get wish message",
				"v-1.0",
				"Term of service"
				,new Contact("Dibakar Maji","www.dibakarmaji.com","dibakarmaji101995@gmail.com"),"Apachi licence","www.apachi.org");
	}
}