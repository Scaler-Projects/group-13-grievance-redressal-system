package com.scaler.commonservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
@Table(name = "greivances")
public class GreivanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int greivance_id;
    private String description;
    private int status;
    private String assignee;
    private String createdBy;
    private String updatedBy;
    private String timeUpdated;
    private String timeCreated;

}
