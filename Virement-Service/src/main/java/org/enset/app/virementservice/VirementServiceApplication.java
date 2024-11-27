package org.enset.app.virementservice;

import org.enset.app.virementservice.entities.Virement;
import org.enset.app.virementservice.enums.VirementType;
import org.enset.app.virementservice.feign.BeneficiareRestClient;
import org.enset.app.virementservice.model.Beneficiare;
import org.enset.app.virementservice.services.VirementService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class VirementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirementServiceApplication.class, args);
    }

    int cpt = 1;

    @Bean
    CommandLineRunner commandLineRunner(VirementService virementService,
                                        BeneficiareRestClient beneficiareRestClient){

        return args -> {
            Collection<Beneficiare> beneficiares = beneficiareRestClient.getAllBeneficiaires().getContent();

            beneficiares.forEach(beneficiare -> {
                Virement virement = Virement.builder()
                        .beneficiaireId(beneficiare.getId())
                        .sourceRIB(beneficiare.getRIB())
                        .amount(7000.0)
                        .description("Virement N°" + cpt)
                        .virementDate(new Date())
                        .type(VirementType.INSTANTANE)
                        .build();

                virementService.createVirement(virement);
                cpt=cpt+1;
            });
        };
    }

}
