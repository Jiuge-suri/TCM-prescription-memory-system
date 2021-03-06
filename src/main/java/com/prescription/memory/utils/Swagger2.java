package com.prescription.memory.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author Yinjie
 * @create 2020/5/10
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Value("${swagger.enable}")
    private boolean enable;
    @Bean
    public Docket createRestApi() {
        List<Parameter> parameterList = new ArrayList<>();
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name("token").description("swagger调试用的模拟传入用户认证凭证").modelRef(new ModelRef("String"))
                .parameterType("header").required(false);
        parameterList.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.prescription.memory.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("中医药方记忆系统API文档")
                .description("中医药方记忆系统API文档")
                .contact(new Contact("Yinjie","","1184557869@qq.com"))
                .version("2.0.1")
                .build();
    }
}