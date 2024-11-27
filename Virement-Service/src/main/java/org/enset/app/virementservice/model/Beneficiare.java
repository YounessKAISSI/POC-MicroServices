package org.enset.app.virementservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Beneficiare {

    private Long id;

    private String firstName;
    private String lastName;
    private String RIB;
    private BeneficiareType type;

}
