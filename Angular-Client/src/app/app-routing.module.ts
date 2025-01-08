import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {VirementsComponent} from "./virements/virements.component";
import {BeneficiairesComponent} from "./beneficiaires/beneficiaires.component";

const routes: Routes = [
  {path : "beneficiaires", component : BeneficiairesComponent},
  {path : "virements", component : VirementsComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
