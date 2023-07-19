import { HttpClient, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthServiceService } from '../api-service/auth-service.service';
import { AuthGuard } from '../auth.guard';
import { LoginService } from '../api-service/login.service';
import { LoginModel } from '../model/login-model';
import { AuthResponse } from '../model/authResponse-model';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  public loginForm !:FormGroup;
  userLogin:LoginModel=new LoginModel();
  user!:AuthResponse; 
  constructor(private formBuilder:FormBuilder, private http:HttpClient ,  private router: Router,private auth:AuthServiceService,private _login:LoginService) { }
  
  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      email:[''],
      password:['']
    })
  }
  
    
  login(){  
       this.userLogin.email=this.loginForm.value.email;
       this.userLogin.password=this.loginForm.value.password;

        this._login.login(this.userLogin).subscribe((res:AuthResponse) => { 
      
          if(res.status==='success'){
            this.auth.isLoggedIn=true;
            this.router.navigate(['/onSuccessLogin']);
          }
          else {
            alert("User Not Found");
          }
      return res},error=>{
        alert("Invalid Credentials");
        window.location.reload();
      });

     
    }
    
  

}
