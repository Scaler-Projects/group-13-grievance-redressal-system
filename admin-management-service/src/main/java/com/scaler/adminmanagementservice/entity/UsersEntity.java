package com.scaler.adminmanagementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

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
    private String timeUpdated;
    private String timeCreated;

}
