package com.scaler.commonservice.models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GreivanceDto {
    private int greivanceId;
    private String description;
    private int status;
    private String assignee;
    private String createdBy;
    private String updatedBy;
    private String timeUpdated;
    private String timeCreated;
}
