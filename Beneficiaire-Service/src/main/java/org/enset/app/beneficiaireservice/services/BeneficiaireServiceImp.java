package org.enset.app.beneficiaireservice.services;

import org.enset.app.beneficiaireservice.dtos.BeneficiaireDTO;
import org.enset.app.beneficiaireservice.entities.Beneficiaire;
import org.enset.app.beneficiaireservice.mappers.BeneficiaireMapperImp;
import org.enset.app.beneficiaireservice.repositories.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BeneficiaireServiceImp implements BeneficiaireService{

    private final BeneficiaireRepository beneficiaireRepository;
    private final BeneficiaireMapperImp dtoMapper;

    public BeneficiaireServiceImp(BeneficiaireRepository beneficiaireRepository, BeneficiaireMapperImp dtoMapper) {
        this.beneficiaireRepository = beneficiaireRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<BeneficiaireDTO> getAllBeneficiaries() {
        List<Beneficiaire> beneficiaires = beneficiaireRepository.findAll();
        return beneficiaires.stream().map(dtoMapper::fromBeneficiaire).collect(Collectors.toList());
    }

    @Override
    public List<BeneficiaireDTO> searchBeneficiaries(String keyword){
        List<Beneficiaire> beneficiaires = beneficiaireRepository.searchBeneficiaries(keyword);
        return beneficiaires.stream().map(dtoMapper::fromBeneficiaire).collect(Collectors.toList());
    }

    @Override
    public BeneficiaireDTO getBeneficiaryById(Long id) {
        Beneficiaire beneficiaire = beneficiaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Beneficiary not found"));
        return dtoMapper.fromBeneficiaire(beneficiaire);
    }

    @Override
    public void deleteBeneficiary(Long id) {
        this.beneficiaireRepository.deleteBeneficiaireById(id);
    }

    @Override
    public Beneficiaire updateBeneficiary(Long id, BeneficiaireDTO updatedBeneficiary) {
        return beneficiaireRepository.findById(id).map(existingBeneficiary -> {
            existingBeneficiary.setFirstName(updatedBeneficiary.getFirstName());
            existingBeneficiary.setLastName(updatedBeneficiary.getLastName());
            existingBeneficiary.setRIB(updatedBeneficiary.getRIB());
            existingBeneficiary.setType(updatedBeneficiary.getType());
            return beneficiaireRepository.save(existingBeneficiary);
        }).orElseThrow(() -> new ResourceNotFoundException("Beneficiary not found with id " + id));
    }

    /*@Override
    public Beneficiaire createBeneficiary(Beneficiaire beneficiaire) {
        return beneficiaireRepository.save(beneficiaire);
    }

    @Override
    public Beneficiaire updateBeneficiary(Beneficiaire beneficiaire) {
        // Vérifier si le bénéficiaire existe déjà
        Optional<Beneficiaire> existingBeneficiary = beneficiaireRepository.findById(beneficiaire.getId());

        if (existingBeneficiary.isPresent()) {
            // Mettre à jour les champs nécessaires
            Beneficiaire beneficiaryToUpdate = existingBeneficiary.get();
            beneficiaryToUpdate.setFirstName(beneficiaire.getFirstName());
            beneficiaryToUpdate.setLastName(beneficiaire.getLastName());
            beneficiaryToUpdate.setType(beneficiaire.getType());
            beneficiaryToUpdate.setRIB(beneficiaire.getRIB());
            // Ajouter ici d'autres champs à mettre à jour

            return beneficiaireRepository.save(beneficiaryToUpdate);
        } else {
            throw new IllegalArgumentException("Le bénéficiaire avec l'ID " + beneficiaire.getId() + " n'existe pas.");
        }
    }

    @Override
    public void deleteBeneficiary(Long id) {
        Optional<Beneficiaire> existingBeneficiary = beneficiaireRepository.findById(id);
        System.out.println(id);
        if (existingBeneficiary.isPresent()) {
            beneficiaireRepository.deleteById(id);
            System.out.println("exist");
        } else {
            throw new IllegalArgumentException("Le bénéficiaire avec l'ID " + id + " n'existe pas.");
        }
    }
*/
//    public void deleteBeneficiary(Long id) {
//        beneficiaireRepository.deleteById(id);
//    }
}
