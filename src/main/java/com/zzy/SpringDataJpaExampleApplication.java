package com.zzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
//@ComponentScan
public class SpringDataJpaExampleApplication {
    public static void main(String[] args) {
        /*
         *http://localhost:8080/users/
            http://localhost:8080/users/add/100/110/111
            http://localhost:8080/users/delete/100
            http://localhost:8080/users/2
            http://localhost:8080/users/search/name/2
         */
        SpringApplication.run(SpringDataJpaExampleApplication.class, args);
    }
}