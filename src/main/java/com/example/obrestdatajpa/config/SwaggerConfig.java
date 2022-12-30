package com.example.obrestdatajpa.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;


/**
 * Configuracion Swagger para la generacion de documentation de la  API REST
 * en base a los controladores
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("REST API",
                "Api books",
                "1.0.0",
                "Apache 2.0",
                new Contact("Juan Paredes","https://www.example.com","jparedes@example.com"),
                "MIT",
                "www.example.com",
                Collections.emptyList());

    }

}
