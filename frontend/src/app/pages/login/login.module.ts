import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login.component';
import { LoginService } from 'src/app/services/login/login.service';

@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    CommonModule]
})
export class LoginModule {
}
