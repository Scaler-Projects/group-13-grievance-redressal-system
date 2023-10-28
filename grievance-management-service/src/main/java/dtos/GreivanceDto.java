package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreivanceDto {
    private String description;
    private String assignee;
    private String createdBy;
    private String updatedBy;
    private Long timeUpdated;
    private Long timeCreated;
}
