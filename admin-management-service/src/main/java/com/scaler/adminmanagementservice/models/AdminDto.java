package com.scaler.adminmanagementservice.models;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdminDto {
  private Long userid ;
  private String username ;
  private String password ;
  private String email ;
  private String phone ;
  private Long timeCreated ;
  private Long timeUpdated ;
}