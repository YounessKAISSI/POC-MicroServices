package org.enset.app.virementservice.mappers;

import org.enset.app.virementservice.dtos.VirementDTO;
import org.enset.app.virementservice.entities.Virement;

public interface VirementMapper {
    VirementDTO fromVirement(Virement virement);
    Virement fromVirementDTO(VirementDTO virementDTO);
}
