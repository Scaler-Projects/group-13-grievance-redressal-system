package com.scaler.adminmanagementservice.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    @Id
    private Long user_id;
}