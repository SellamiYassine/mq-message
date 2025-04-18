package org.bank.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "partenaires")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partenaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String alias;

    @NotBlank
    private String type;

    @Enumerated(EnumType.STRING)
    private Direction direction = Direction.INBOUND;

    private String application;

    @Enumerated(EnumType.STRING)
    private ProcessedFlowType processedFlowType = ProcessedFlowType.MESSAGE;

    @NotBlank
    private String description;

    // Enum definitions
    public enum Direction {
        INBOUND, OUTBOUND
    }

    public enum ProcessedFlowType {
        MESSAGE, ALERTING, NOTIFICATION
    }
}

