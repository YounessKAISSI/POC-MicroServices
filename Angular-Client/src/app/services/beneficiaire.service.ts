import { Injectable } from '@angular/core';
import {Beneficiaire} from "../models/Beneficiaire.model";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class BeneficiaireService {
  private baseUrl = 'http://localhost:8888/beneficiaire-service/beneficiaires';
  beneficiaires! : Array<Beneficiaire>;

  constructor(private http:HttpClient) { }

   loadBeneficiaires() : Observable<Array<Beneficiaire>> {
      return this.http.get<Array<Beneficiaire>>(this.baseUrl);
  }

  getBeneficiaireById(id : number):Observable<Beneficiaire>{
    return this.http.get<Beneficiaire>(this.baseUrl + `/${id}`);
  }

  searchBeneficiaires(keyword : string):Observable<Array<Beneficiaire>>{
    return this.http.get<Array<Beneficiaire>>(this.baseUrl + `/search?keyword=${keyword}`);
  }

  updateBeneficiaireById(b:Beneficiaire) {
    console.log(`update id=${b.id}`);
    this.http.put<Beneficiaire>(this.baseUrl + `/${b.id}`,b);
  }

  deleteBeneficiaireById(id:number) {
    console.log(`delete id=${id}`);
    this.http.delete(`${this.baseUrl}/${id}`).subscribe({
      next: () => {
        console.log(`Bénéficiaire avec id=${id} supprimé avec succès`);
        // Mettez à jour la liste des bénéficiaires
        this.beneficiaires = this.beneficiaires.filter(b => b.id !== id);
      },
      error: (err) => {
        console.error(`Erreur lors de la suppression du bénéficiaire avec id=${id}:`, err);
      }
    });
  }
}
