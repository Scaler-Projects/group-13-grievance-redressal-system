package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
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
@JsonIgnoreType
public class Greivance {
    @Id
    @GeneratedValue
    private int greivance_id;
    private String description;
    private String assignee;
    private String createdBy;
    private String updatedBy;
    private Long timeUpdated;
    private Long timeCreated;

}
