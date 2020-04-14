package com.example.apispringboot.config;

import java.util.ArrayList;

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
  public Docket productApi(){
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example.apispringboot"))
        .paths(PathSelectors.regex("/api.*")).build().apiInfo(metaInfo());
  }

  private ApiInfo metaInfo(){
    ApiInfo apiInfo =  new ApiInfo(
      "ApiSpringBoot", 
      "Uma api, para fins de aprendizado", 
      "1.0", 
      "Terms of Service", 
      new Contact("Josué Batista","https://github.com/Josuebmota", null), 
      "Apache License Version 2.0", 
      "http://www.apache.org/licenses/LICENSE-2.0",
      new ArrayList<VendorExtension>()
    );
    return apiInfo;
  }
}