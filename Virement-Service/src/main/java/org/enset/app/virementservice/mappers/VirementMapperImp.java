package org.enset.app.virementservice.mappers;

import org.enset.app.virementservice.dtos.VirementDTO;
import org.enset.app.virementservice.entities.Virement;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VirementMapperImp implements VirementMapper{

    @Override
    public VirementDTO fromVirement(Virement virement){
        VirementDTO virementDTO = new VirementDTO();
        BeanUtils.copyProperties(virement,virementDTO);
        return virementDTO;
    }

    @Override
    public Virement fromVirementDTO(VirementDTO virementDTO) {
        Virement virement = new Virement();
        BeanUtils.copyProperties(virementDTO,virement);
        return virement;
    }
}
