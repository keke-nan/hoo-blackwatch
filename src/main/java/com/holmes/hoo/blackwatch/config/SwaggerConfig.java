package com.holmes.hoo.blackwatch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value("${swagger.enable: true}")
    private Boolean enableFlag;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enableFlag)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.holmes.hoo.blackwatch.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("BlackWatch Management")
                .description("BlackWatch Management的API接口定义")
                .version("1.0.0-SNAPSHOT ")
                .build();
    }

}