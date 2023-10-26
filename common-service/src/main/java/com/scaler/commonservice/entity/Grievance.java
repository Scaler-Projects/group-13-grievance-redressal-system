package com.scaler.commonservice.entity;

import javax.persistence.*;

@Entity
public class Grievance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String grievance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
