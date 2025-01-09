package org.enset.app.beneficiaireservice.dtos;

import lombok.Data;
import org.enset.app.beneficiaireservice.enums.BeneficiareType;

@Data
public class BeneficiaireDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String RIB;
    private BeneficiareType type;
}
