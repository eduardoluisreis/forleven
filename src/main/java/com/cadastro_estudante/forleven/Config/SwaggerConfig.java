package com.cadastro_estudante.forleven.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration

public class SwaggerConfig {
    @Bean
    public Docket forlevenApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cadastro_estudante.forleven"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo());
    }

    @org.jetbrains.annotations.NotNull
    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "forleven Application API REST",
                "API CRUD ",
                "1.0",
                "Terms of Service",
                new Contact("Eduardo Reis","https://wedinfo.freshdesk.com/support/home","eduardoluisreis@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}
