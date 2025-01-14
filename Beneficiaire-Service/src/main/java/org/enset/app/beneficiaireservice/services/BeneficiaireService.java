package org.enset.app.beneficiaireservice.services;

import org.enset.app.beneficiaireservice.dtos.BeneficiaireDTO;
import org.enset.app.beneficiaireservice.entities.Beneficiaire;

import java.util.List;

public interface BeneficiaireService {
    List<BeneficiaireDTO> getAllBeneficiaries();
    List<BeneficiaireDTO> searchBeneficiaries(String keyword);
    BeneficiaireDTO getBeneficiaryById(Long id);
    void deleteBeneficiary(Long id);
    Beneficiaire updateBeneficiary(Long id,BeneficiaireDTO beneficiaireDTO);
    //BeneficiaireDTO createBeneficiary(Beneficiaire beneficiaire);
   // void deleteBeneficiary(Long id);

}
