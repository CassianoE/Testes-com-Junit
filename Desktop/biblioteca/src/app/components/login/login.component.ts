import { Component, inject } from '@angular/core';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [MdbFormsModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  username: string = "";
  senha: string = "";

  router = inject(Router);


  logar(){
    if (this.username == "admin" && this.senha == "admin") {
      this.router.navigate(['principal']);
    } else {
      alert("Usuario ou senha errado")
    }
      
    
  }

}
