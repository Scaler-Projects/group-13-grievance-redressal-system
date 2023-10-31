package com.scaler.adminmanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.threeten.bp.OffsetDateTime;

import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UsersEntity extends BaseModel{
    private String username;
    private String email;
    private String password;
    private int role_id;
    private String phone_number;
    private long timeUpdated;
    private long timeCreated;

}
