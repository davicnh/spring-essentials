package org.example.springessentials.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "avaliacoes_fisicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assesstment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal bodyFat;
}
