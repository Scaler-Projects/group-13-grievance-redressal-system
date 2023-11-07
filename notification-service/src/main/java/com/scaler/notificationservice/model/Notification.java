package com.scaler.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notification")
public class Notification extends BaseModel{
    @Column
    private Long grievanceId;
    @Column
    private String prevState;
    @Column
    private String newState;
    @Column
    private String updatedBy;
    @Column
    private String notifiedUser;
    @Column
    private Long notificationTime;


}
