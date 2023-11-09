package com.scaler.commonservice.repository;


import com.scaler.commonservice.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<UsersEntity,Integer> {
    @Query("select u from UsersEntity u where u.role.role_id =:role_id")
    List<UsersEntity> findUsersEntityByRole_idEquals(@Param("role_id")Integer roleId);

    @Query("select u from UsersEntity u where u.user_id =:user_id")
    Optional<UsersEntity> findUsersEntityByUser_idEquals(@Param("user_id")Integer userId);
}