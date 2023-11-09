package com.scaler.commonservice.repository;

import com.scaler.commonservice.entity.GreivanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreivanceRepository extends JpaRepository<GreivanceEntity,Integer> {
}
