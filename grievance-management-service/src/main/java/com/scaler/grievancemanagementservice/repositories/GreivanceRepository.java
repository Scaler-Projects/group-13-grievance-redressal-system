package com.scaler.grievancemanagementservice.repositories;

import com.scaler.grievancemanagementservice.entities.Greivance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreivanceRepository extends JpaRepository<Greivance,Integer> {
}
