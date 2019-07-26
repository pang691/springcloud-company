package com.taikang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Movie2App {
    public static void main(String[] args) {
        SpringApplication.run(Movie2App.class,args);
    }
}
