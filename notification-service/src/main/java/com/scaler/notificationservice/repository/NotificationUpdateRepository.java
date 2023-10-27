package com.scaler.notificationservice.repository;

import com.scaler.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationUpdateRepository extends JpaRepository<Notification, Integer> {
    Optional<Notification> findByGrievanceId(int grievanceId);
    @Query("SELECT nu.notified_user FROM Notification nu WHERE nu.grievance_id = :grievanceId")
    String findEmailByGrievanceId(@Param("grievanceId") int grievanceId);

    // Custom query to retrieve prev_state, new_state, and updated_by based on grievance_id
    @Query("SELECT n.prev_state, n.new_state, n.updated_by FROM Notification n WHERE n.grievance_id = :grievanceId")
    Object[] findFieldsByGrievanceId(@Param("grievanceId") int grievanceId);
}
