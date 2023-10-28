package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int user_id;
    private String username;
    private String password;
    private Role role_id;
    private String email_id;
    private String phone;
    private Long timeUpdated;
    private Long timeCreated;

}
