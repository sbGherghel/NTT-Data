package org.example.petapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class Petv3Application {

    public static void main(String[] args) {

        SpringApplication.run(Petv3Application.class, args);
    }

}
