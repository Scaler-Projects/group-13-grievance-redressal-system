package com.scaler.notificationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends BaseModel{
    private  int grievance_id;
    private String prev_state;
    private String new_state;
    private String updated_by;
    private String notified_user;
    private long notification_time;


}
