import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Virement} from "../models/Virement.model";

@Injectable({
  providedIn: 'root'
})

export class VirementService {
  private baseUrl = 'http://localhost:8888/virement-service/virements';
  private baseUrlService = 'http://localhost:8082/virements';
  virements! : Observable<Array<Virement>>;

  constructor(private http:HttpClient) { }

  loadVirements() : Observable<Array<Virement>> {
    return this.http.get<Array<Virement>>(this.baseUrl);
  }

  getVirementById(id : number):Observable<Virement>{
    return this.http.get<Virement>(this.baseUrl + `/${id}`);
  }

  searchVirements(keyword : string):Observable<Array<Virement>>{
    return this.http.get<Array<Virement>>(this.baseUrl + `/search?keyword=${keyword}`);
  }

  updateVirementById(v:Virement) {
    console.log(`update id=${v.id}`);
    this.http.put<Virement>(this.baseUrl + `/${v.id}`,v);
  }

  deleteVirementById(id:number) {
    console.log(`delete id=${id}`);
    this.http.delete(`${this.baseUrlService}/${id}`).subscribe({
      next: ()  => {
        console.log(`Virement avec id=${id} supprimé avec succès`);
        this.loadVirements();
      },
      error: (err) => {
        console.error(`Erreur lors de la suppression du virement avec id=${id}:`, err);
      }
    });
  }
}
