package com.scaler.notificationservice.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UsersEntity{
    @Id
    private Long user_id;
    private String username;
    private String email;
    private String password;
    private int role_id;
    private String phone_number;
    private long timeUpdated;
    private long timeCreated;

}