package com.sbb.flexrate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("/main/hello"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("FlexRate API 명세서")
                .version("1.0.0")
                .description("멋사 11기 겨울잠 프로젝트")
                .build();
    }

    @Bean
    public Docket creditApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("credit") //그룹 이름 지정
                .apiInfo(apiInfo())
                .select()
                .paths(path->path.startsWith("/credit"))
                .build();
    }

    @Bean
    public Docket signApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("sign")
                .apiInfo(apiInfo())
                .select()
                .paths(path->path.startsWith("/login")||path.startsWith("/register")||path.startsWith("/user")|| path.startsWith("/admin"))
                .build();
    }
}