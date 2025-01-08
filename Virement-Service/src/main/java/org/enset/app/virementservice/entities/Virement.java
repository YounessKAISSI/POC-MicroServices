package org.enset.app.virementservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.enset.app.virementservice.enums.VirementType;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
public class Virement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long beneficiaireId;
    private String sourceRIB;
    private Double amount;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date virementDate;
    private VirementType type;

}
