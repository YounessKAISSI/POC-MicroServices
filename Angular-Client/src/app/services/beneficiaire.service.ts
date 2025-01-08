import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BeneficiaireService {
  private baseUrl = 'http://localhost:8888/beneficiaire-service/beneficiares';

  constructor() { }
}
