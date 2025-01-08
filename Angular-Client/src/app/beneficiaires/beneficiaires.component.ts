import { Component } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Beneficiaire} from "../models/Beneficiaire.model";
import {Observable} from "rxjs";

@Component({
  selector: 'app-beneficiares',
  templateUrl: './beneficiaires.component.html',
  styleUrl: './beneficiaires.component.css'
})
export class BeneficiairesComponent {
  public beneficiares : any;
  private baseUrl = 'https://localhost:8888/beneficiaire-service/beneficiaires';

  constructor(private http : HttpClient, private router : Router) {
  }

  ngOnInit() {
    this.loadBeneficiaires()
  }

  private loadBeneficiaires() {
    this.http.get<Array<Beneficiaire>>("http://localhost:8888/beneficiaire-service/beneficiaires").subscribe({
      next : beneficiares => {
        this.beneficiares = beneficiares;
      },
      error : err => {
        console.log(err);
      }
    })
  }

  updateBeneficiaire(b:Beneficiaire) :Observable<Beneficiaire> {
      return this.http.put<Beneficiaire>(`${this.baseUrl}/${b.id}`, b);
  }

  deleteBeneficiaireById(id:number) {
    console.log(`delete id=${id}`)
    this.http.delete(`http://localhost:8888/beneficiaire-service/api/beneficiaires/${id}`).subscribe({
      next: () => {
        console.log(`Bénéficiaire avec ID ${id} supprimé avec succès.`);
        // actualiser la liste.
        this.loadBeneficiaires();
      },
      error: (err) => {
        console.error("Erreur lors de la suppression du bénéficiaire :", err);
        // Ajoutez une notification ou une alerte pour informer l'utilisateur.
      },
      complete: () => {
        console.log("Requête de suppression terminée.");
      }
    });
  }
}
