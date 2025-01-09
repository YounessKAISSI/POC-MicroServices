import {Component, OnInit} from '@angular/core';
import {catchError, Observable, throwError} from "rxjs";
import {FormBuilder, FormGroup} from "@angular/forms";
import {VirementService} from "../services/virement.service";
import {Virement} from "../models/Virement.model";

@Component({
  selector: 'app-virements',
  templateUrl: './virements.component.html',
  styleUrl: './virements.component.css'
})
export class VirementsComponent implements OnInit{
  virements! : Observable<Array<Virement>>;
  selectedVirement!: Virement;
  formulaireModal!: FormGroup;
  searchFormGroup! : FormGroup;
  errorMessage! : object;

  constructor(private virementService : VirementService,private fb: FormBuilder) {
  }

  ngOnInit() {
    this.virements = this.virementService.loadVirements().pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      })
    );

    this.initialiseFormulmaireModal();

    this.searchFormGroup = this.fb.group({
      keyword: this.fb.control("")
    });
  }

  editVirement(id: number): void {
    this.virementService.getVirementById(id).subscribe(
      (virement) => {
        this.selectedVirement = virement;
        if (this.selectedVirement) {
          this.formulaireModal.patchValue(this.selectedVirement);
        }
      },
      (error) => {
        console.error('Erreur lors de la récupération du virement :', error);
        alert('Impossible de récupérer les informations du virement.');
      }
    );
  }

  handleUpdateVirement(v:Virement)  {
    this.virementService.updateVirementById(v);
    this.virementService.loadVirements();
  }

  handleDeleteVirement(id: number) {
    this.virementService.deleteVirementById(id);
    this.virementService.loadVirements();
  }

  handelSearchVirements() {
    let kw = this.searchFormGroup?.value.keyword;
    this.virements = this.virementService.searchVirements(kw);
  }

  handleCreateVirement() {
    this.initialiseFormulmaireModal();
  }

  initialiseFormulmaireModal(){
    this.formulaireModal = this.fb.group({
      id: [{ value: '', disabled: true }],
      beneficiaireId: [''],
      sourceRIB: [''],
      amount: [''],
      description: [''],
      virementDate: [''],
      type: ['']
    });
  }
}
