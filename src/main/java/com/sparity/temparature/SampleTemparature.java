package com.sparity.temparature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Suresh
 */
@SpringBootApplication(exclude = {Neo4jDataAutoConfiguration.class})
@EnableSwagger2
public class SampleTemparature {

    public static void main(String[] args) {
        SpringApplication.run(SampleTemparature.class, args);
    }
}
