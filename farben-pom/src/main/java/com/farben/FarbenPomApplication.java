package com.farben;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.farben.*")
public class FarbenPomApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarbenPomApplication.class, args);
    }

}
