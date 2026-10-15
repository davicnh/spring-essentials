package org.example.springessentials.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutDTO {

    @NotBlank
    private UUID studentID;

    @NotBlank
    private String workoutName;

    @NotEmpty
    private List<UUID> exercisesIDs;
}
