package org.enset.app.virementservice.web;

import org.enset.app.virementservice.entities.Virement;
import org.enset.app.virementservice.services.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/virements")
public class VirementRestController {
    @Autowired
    private VirementService virementService;

    @GetMapping
    public List<Virement> getAllTransfers() {
        return virementService.getAllVirements();
    }

    @GetMapping("/{id}")
    public Virement getVirement(@PathVariable Long id) {
        return virementService.getVirementById(id);
    }

    @PostMapping
    public Virement createVirement(@RequestBody Virement virement) {
        return virementService.createVirement(virement);
    }

    @GetMapping("/beneficiaires/{beneficiaireId}")
    public List<Virement> getVirementsByBeneficiaire(@PathVariable Long beneficiaireId) {
        return virementService.getVirementsByBeneficiaire(beneficiaireId);
    }
}
