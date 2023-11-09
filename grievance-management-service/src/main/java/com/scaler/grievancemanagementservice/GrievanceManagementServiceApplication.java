package com.scaler.grievancemanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.scaler.*")
@EnableJpaRepositories("com.scaler.*")
public class GrievanceManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrievanceManagementServiceApplication.class, args);
    }

}
