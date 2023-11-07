package com.scaler.commonservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class RolesEntity{
    @Id
    @Column(name = "role_id" ,unique = true)
    private int role_id;
    private String role_name;
    private String timeCreated;

    @OneToMany(mappedBy = "role")
    private Set<UsersEntity> users;
}
