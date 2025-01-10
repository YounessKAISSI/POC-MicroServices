import {Component, OnInit} from '@angular/core';
import {Beneficiaire} from "../models/Beneficiaire.model";
import {catchError, Observable, throwError} from "rxjs";
import {BeneficiaireService} from "../services/beneficiaire.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-beneficiares',
  templateUrl: './beneficiaires.component.html',
  styleUrl: './beneficiaires.component.css'
})

export class BeneficiairesComponent implements OnInit{
  beneficiaires! : Observable<Array<Beneficiaire>>;
  selectedBeneficiary!: Beneficiaire;
  formulaireModal!: FormGroup;
  searchFormGroup! : FormGroup;
  errorMessage! : object;

  constructor(private beneficiaireService : BeneficiaireService,private fb: FormBuilder) {
  }

  ngOnInit() {
    this.beneficiaires = this.beneficiaireService.loadBeneficiaires().pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      })
    );

    this.formulaireModal = this.fb.group({
      id: [{ value: '', disabled: true }],
      firstName: [''],
      lastName: [''],
      type: [''],
      rib: ['']
    });

    this.searchFormGroup = this.fb.group({
      keyword: this.fb.control("")
    });
  }

  editBeneficiaire(id: number): void {
    this.beneficiaireService.getBeneficiaireById(id).subscribe(
      (beneficiaire) => {
        this.selectedBeneficiary = beneficiaire;
        if (this.selectedBeneficiary) {
          this.formulaireModal.patchValue(this.selectedBeneficiary);
        }
      },
      (error) => {
        console.error('Erreur lors de la récupération du bénéficiaire :', error);
        alert('Impossible de récupérer les informations du bénéficiaire.');
      }
    );
  }

  handleUpdateBeneficiaire(b:Beneficiaire)  {
    this.beneficiaireService.updateBeneficiaireById(b);
    this.beneficiaires = this.beneficiaireService.loadBeneficiaires();
  }

  handleDeleteBeneficiaire(id: number) {
    const confirmation = window.confirm('Êtes-vous sûr de vouloir supprimer ce bénéficiaire id = ' + id + " ?");
    if (confirmation) {
      this.beneficiaireService.deleteBeneficiaireById(id);
      this.beneficiaires = this.beneficiaireService.loadBeneficiaires();
    }
  }

  handelSearchBeneficiaires() {
    let kw = this.searchFormGroup?.value.keyword;
    this.beneficiaires = this.beneficiaireService.searchBeneficiaires(kw);
  }

  handleCreateBeneficiaire() {
    this.formulaireModal = this.fb.group({
      id: [{ value: '', disabled: true }],
      firstName: [''],
      lastName: [''],
      type: [''],
      rib: ['']
    });
  }
}
