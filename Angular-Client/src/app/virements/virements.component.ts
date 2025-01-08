import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-virements',
  templateUrl: './virements.component.html',
  styleUrl: './virements.component.css'
})
export class VirementsComponent implements OnInit{
  public virements : any;

  constructor(private http : HttpClient, private router : Router) {
  }

    ngOnInit(): void {
      this.http.get("http://localhost:8888/virement-service/virements").subscribe({
        next : virements => {
          this.virements = virements;
        },
        error : err => {
          console.log(err);
        }
      })
    }

}
