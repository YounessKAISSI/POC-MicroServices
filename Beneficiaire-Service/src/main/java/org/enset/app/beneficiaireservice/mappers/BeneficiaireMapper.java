package org.enset.app.beneficiaireservice.mappers;

import org.enset.app.beneficiaireservice.dtos.BeneficiaireDTO;
import org.enset.app.beneficiaireservice.entities.Beneficiaire;

public interface BeneficiaireMapper {
    BeneficiaireDTO fromBeneficiaire(Beneficiaire beneficiaire);
    Beneficiaire fromBeneficiaireDTO(BeneficiaireDTO beneficiaireDTO);
}
