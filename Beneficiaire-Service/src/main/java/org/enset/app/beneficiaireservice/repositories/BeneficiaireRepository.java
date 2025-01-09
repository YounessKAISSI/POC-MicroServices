package org.enset.app.beneficiaireservice.repositories;

import org.enset.app.beneficiaireservice.entities.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long> {
    @Query("select b from Beneficiaire b where b.firstName like :kw or b.lastName like :kw")
    List<Beneficiaire> searchBeneficiaries(@Param("kw") String keyword);
    void deleteBeneficiaireById(Long Id);
}
