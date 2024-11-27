package org.enset.app.virementservice.feign;

import org.enset.app.virementservice.model.Beneficiare;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "beneficiaire-service")
public interface BeneficiareRestClient {

    @GetMapping("/api/beneficiaires")
    PagedModel<Beneficiare> getAllBeneficiaires();

    @GetMapping("/api/beneficiaires/{id}")
    Beneficiare findBeneficiareById(@PathVariable Long id);

}
