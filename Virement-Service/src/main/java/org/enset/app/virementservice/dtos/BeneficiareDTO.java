package org.enset.app.virementservice.dtos;

import lombok.Data;
import org.enset.app.virementservice.model.BeneficiareType;

@Data
public class BeneficiareDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String RIB;
    private BeneficiareType type;
}
