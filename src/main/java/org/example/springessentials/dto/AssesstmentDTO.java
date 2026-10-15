package org.example.springessentials.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssesstmentDTO {

    @NotBlank
    private UUID studentId;

    @NotBlank
    private BigDecimal weight;

    @NotBlank
    private BigDecimal height;

    @NotBlank
    private BigDecimal bodyFat;

}
