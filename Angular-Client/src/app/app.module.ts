import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TemplateComponent } from './template/template.component';
import {RouterOutlet} from "@angular/router";
import { VirementsComponent } from './virements/virements.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { EditBeneficiaireComponent } from './edit-beneficiaire/edit-beneficiaire.component';
import { BeneficiairesComponent } from './beneficiaires/beneficiaires.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    TemplateComponent,
    BeneficiairesComponent,
    VirementsComponent,
    EditBeneficiaireComponent,
    BeneficiairesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
