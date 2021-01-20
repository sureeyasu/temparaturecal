package com.sparity.temparature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Suresh
 */
@SpringBootApplication
@EnableSwagger2
public class SampleTemparature {

    public static void main(String[] args) {
        SpringApplication.run(SampleTemparature.class, args);
    }
}
