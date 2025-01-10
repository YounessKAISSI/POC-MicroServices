package org.enset.app.beneficiaireservice;

import org.enset.app.beneficiaireservice.entities.Beneficiaire;
import org.enset.app.beneficiaireservice.enums.BeneficiareType;
import org.enset.app.beneficiaireservice.repositories.BeneficiaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeneficiaireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneficiaireServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BeneficiaireRepository beneficiaireRepository){
        return args -> {
            beneficiaireRepository.save(Beneficiaire.builder()
                    .firstName("Youness")
                    .lastName("Kaissi")
                    .RIB("1111 2222 3333 4444")
                    .type(BeneficiareType.MORALE)
                    .build());
            beneficiaireRepository.save(Beneficiaire.builder()
                    .firstName("MOHAMED")
                    .lastName("MOHAMED")
                    .RIB("2222 3333 4444 5555")
                    .type(BeneficiareType.PHYSIQUE)
                    .build());
            beneficiaireRepository.save(Beneficiaire.builder()
                    .firstName("Yassine")
                    .lastName("Kaissi")
                    .RIB("3333 4444 5555 6666")
                    .type(BeneficiareType.MORALE)
                    .build());
            beneficiaireRepository.save(Beneficiaire.builder()
                    .firstName("TEST")
                    .lastName("1111")
                    .RIB("1111 1111 1111 1111")
                    .type(BeneficiareType.MORALE)
                    .build());
            beneficiaireRepository.save(Beneficiaire.builder()
                    .firstName("TEST")
                    .lastName("2222")
                    .RIB("2222 2222 2222 2222")
                    .type(BeneficiareType.MORALE)
                    .build());
            beneficiaireRepository.findAll().forEach(c->{
                System.out.println("===================");
                System.out.println(c.getId());
                System.out.println(c.getFirstName());
                System.out.println(c.getLastName());
                System.out.println(c.getRIB());
                System.out.println(c.getType());
                System.out.println("===================");
            });

        };
    }

}
