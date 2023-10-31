package com.scaler.adminmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.scaler.adminmanagementservice.Services")
public class AdminManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminManagementServiceApplication.class, args);
    }

}
