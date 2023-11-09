package com.scaler.commonservice.models;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AdminDto {
  private Integer userid ;
  private String username ;
  private String password ;
  private String email ;
  private String phone ;
  private String timeCreated ;
  private String timeUpdated ;
}