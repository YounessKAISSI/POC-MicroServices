package org.enset.app.beneficiaireservice.mappers;

import org.enset.app.beneficiaireservice.dtos.BeneficiaireDTO;
import org.enset.app.beneficiaireservice.entities.Beneficiaire;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaireMapperImp implements BeneficiaireMapper{

    @Override
    public BeneficiaireDTO fromBeneficiaire(Beneficiaire beneficiaire){
        BeneficiaireDTO beneficiaireDTO=new BeneficiaireDTO();
        BeanUtils.copyProperties(beneficiaire,beneficiaireDTO);
        return  beneficiaireDTO;
    }

    @Override
    public Beneficiaire fromBeneficiaireDTO(BeneficiaireDTO beneficiaireDTO){
        Beneficiaire beneficiaire=new Beneficiaire();
        BeanUtils.copyProperties(beneficiaireDTO,beneficiaire);
        return  beneficiaire;
    }
}
