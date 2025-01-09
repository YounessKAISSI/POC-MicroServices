package org.enset.app.virementservice.web;

import org.enset.app.virementservice.dtos.VirementDTO;
import org.enset.app.virementservice.entities.Virement;
import org.enset.app.virementservice.services.VirementService;
import org.enset.app.virementservice.services.VirementServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/virements")
@CrossOrigin("*")
public class VirementRestController {

    private final VirementServiceImp virementService;

    public VirementRestController(VirementServiceImp virementService) {
        this.virementService = virementService;
    }

    @GetMapping
    public List<VirementDTO> getAllTransfers() {
        return virementService.getAllVirements();
    }

    @GetMapping("/{id}")
    public VirementDTO getVirement(@PathVariable Long id) {
        return virementService.getVirementById(id);
    }

    @PostMapping
    public Virement createVirement(@RequestBody VirementDTO virementDTO) {
        return virementService.createVirement(virementDTO);
    }

    @GetMapping("/beneficiaires/{beneficiaireId}")
    public List<VirementDTO> getVirementsByBeneficiaire(@PathVariable Long beneficiaireId) {
        return virementService.getVirementsByBeneficiaire(beneficiaireId);
    }
}
