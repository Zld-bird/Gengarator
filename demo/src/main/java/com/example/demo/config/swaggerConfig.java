package com.example.demo.config;

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

/**
 * @author admin
 * date: 2020/8/26
 * version: 02.06
 */
// Swagger的开关，表示已经启用Swagger
@EnableSwagger2
// 声明当前配置类
@Configuration
public class swaggerConfig {
    @Value("${swagger.enabled}")
    private boolean enableSwagger;

    @Value("${swagger.basePackage}")
    private String basePackage;

   @Bean
    public Docket createRestApi(){
       return  new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
               .enable(enableSwagger)
               .select()
               .apis(RequestHandlerSelectors.basePackage(basePackage))
               .paths(PathSelectors.any())
               .build();
   }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("企业基本信息接口")
                .description("this is a.json great project!!!")
                .version("0.3").build();
    }

}
