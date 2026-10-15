package org.example.springessentials.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    private String name;
    private String email;
}
