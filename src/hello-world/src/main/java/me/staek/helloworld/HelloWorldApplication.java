package me.staek.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

/**
 * SpringBoot 3.0 부터 @EnableBatchProcessing 사용X
 * https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.0-Migration-Guide#spring-batch-changes
 */
//@EnableBatchProcessing
@SpringBootApplication
public class HelloWorldApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
