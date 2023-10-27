package com.scaler.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
public class NotificationMessageRequest {
    private  int grievance_id;
    private String prev_state;
    private String new_state;
    private String updated_by;
    private String notified_user;
    private long notification_time;

}
