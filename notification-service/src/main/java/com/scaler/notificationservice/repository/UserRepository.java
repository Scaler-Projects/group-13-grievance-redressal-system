package com.scaler.notificationservice.repository;


import com.scaler.notificationservice.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findByUsername(String userName);

   }

