package com.scaler.notificationservice.repository;

import com.scaler.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationUpdateRepository extends JpaRepository<Notification, Long> {
    Optional<Notification> findByGrievanceId(Long grievanceId);

    @Query("SELECT n.notifiedUser FROM Notification n WHERE n.grievanceId = :grievanceId")
    String findUserByGrievanceId(@Param("grievanceId") Long grievanceId);

    @Query("SELECT n.prevState, n.newState, n.updatedBy FROM Notification n WHERE n.grievanceId = :grievanceId")
    Object[] findFieldsByGrievanceId(@Param("grievanceId") Long grievanceId);



}
