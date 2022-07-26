package com.cloud.wjb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SwaggerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerServiceApplication.class, args);
    }

}
