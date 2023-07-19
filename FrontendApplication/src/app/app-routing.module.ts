import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';

import { ProductDetailsComponent } from './dashboard/product-details/product-details.component';
import { ResultPageComponent } from './dashboard/result-page/result-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';

const routes: Routes = [
  { path: '', component: LoginPageComponent },
  { path: 'registerpage', component: RegistrationPageComponent },
  { path: 'resultPage', component: ResultPageComponent,canActivate:[AuthGuard]},
   { path: 'onSuccessLogin', component: ResultPageComponent ,canActivate:[AuthGuard]},
   { path: 'product/:id', component: ProductDetailsComponent ,canActivate:[AuthGuard]}
   //,canActivate:[AuthGuard]
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
