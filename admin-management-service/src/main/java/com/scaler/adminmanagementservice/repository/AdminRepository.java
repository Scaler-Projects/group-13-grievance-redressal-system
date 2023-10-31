package com.scaler.adminmanagementservice.repository;


import com.scaler.adminmanagementservice.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<UsersEntity,Integer> {
}