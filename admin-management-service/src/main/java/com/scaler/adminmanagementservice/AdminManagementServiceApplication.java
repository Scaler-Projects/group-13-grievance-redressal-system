package com.scaler.adminmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.scaler.*")
@EnableJpaRepositories("com.scaler.*")
public class AdminManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminManagementServiceApplication.class, args);
    }

}
