package org.enset.app.virementservice.repositories;

import org.enset.app.virementservice.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VirementRepository extends JpaRepository<Virement, Long> {
    List<Virement> findByBeneficiaireId(Long beneficiaireId);

}
