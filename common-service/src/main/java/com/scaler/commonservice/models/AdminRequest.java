package com.scaler.commonservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Admin
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-10-26T11:28:10.312553+05:30[Asia/Kolkata]")


public class AdminRequest {
  @JsonProperty("userid")
  private Long userid = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("timeCreated")
  private OffsetDateTime timeCreated = null;

  @JsonProperty("timeUpdated")
  private OffsetDateTime timeUpdated = null;

  public AdminRequest userid(Long userid) {
    this.userid = userid;
    return this;
  }

  /**
   * Get userid
   * @return userid
   **/
  @Schema(example = "1", description = "")
  
    public Long getUserid() {
    return userid;
  }

  public void setUserid(Long userid) {
    this.userid = userid;
  }

  public AdminRequest username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   **/
  @Schema(example = "Kashish", description = "")
  
    public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public AdminRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   **/
  @Schema(example = "password", description = "")
  
    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AdminRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(example = "kashishsingh355@gmail.com", description = "")
  
    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AdminRequest phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
   **/
  @Schema(example = "9922345623", description = "")
  
    public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public AdminRequest timeCreated(OffsetDateTime timeCreated) {
    this.timeCreated = timeCreated;
    return this;
  }

  /**
   * Get timeCreated
   * @return timeCreated
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(OffsetDateTime timeCreated) {
    this.timeCreated = timeCreated;
  }

  public AdminRequest timeUpdated(OffsetDateTime timeUpdated) {
    this.timeUpdated = timeUpdated;
    return this;
  }

  /**
   * Get timeUpdated
   * @return timeUpdated
   **/
  @Schema(description = "")
  
    @Valid
    public OffsetDateTime getTimeUpdated() {
    return timeUpdated;
  }

  public void setTimeUpdated(OffsetDateTime timeUpdated) {
    this.timeUpdated = timeUpdated;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminRequest admin = (AdminRequest) o;
    return Objects.equals(this.userid, admin.userid) &&
        Objects.equals(this.username, admin.username) &&
        Objects.equals(this.password, admin.password) &&
        Objects.equals(this.email, admin.email) &&
        Objects.equals(this.phone, admin.phone) &&
        Objects.equals(this.timeCreated, admin.timeCreated) &&
        Objects.equals(this.timeUpdated, admin.timeUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userid, username, password, email, phone, timeCreated, timeUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Admin {\n");
    
    sb.append("    userid: ").append(toIndentedString(userid)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    timeCreated: ").append(toIndentedString(timeCreated)).append("\n");
    sb.append("    timeUpdated: ").append(toIndentedString(timeUpdated)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
