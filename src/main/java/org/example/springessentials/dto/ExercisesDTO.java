package org.example.springessentials.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ExercisesDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String muscularGroup;

}
