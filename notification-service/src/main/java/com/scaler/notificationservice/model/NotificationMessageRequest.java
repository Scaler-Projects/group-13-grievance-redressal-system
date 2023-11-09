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
    private  Long grievanceId;
    private String prevState;
    private String newState;
    private String updatedBy;
    private String notifiedUser;
    private Long notificationTime;

}
