import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formUserLogin!: FormGroup;
  disableLoginWithEmail = true;

  constructor(
    private router: Router,
    private login$: LoginService) {

    this.formUserLogin = new FormGroup({
      email: new FormControl(["", Validators.email])
    });
  }

  ngOnInit(): void {
    
  }

  loginWithEmail() {
    return false;
  }

  loginWithGoogle() {
    this.login$.login().then((data) => {
      console.log(data);
      // this.router.navigate(['/menu-admin']);
    });
    return false;
  }

}
