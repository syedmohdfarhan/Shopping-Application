import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms'
import { Router } from '@angular/router';
import { RegistrationPageApiService } from '../api-service/registration-page-api.service';
import { registrationPageModel } from '../model/registration-page-model';
@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {
  
  formValue !: FormGroup;
  RegistrationPageModelObject : registrationPageModel = new registrationPageModel();
  constructor(private formbuilder: FormBuilder,
    private api: RegistrationPageApiService ,
  
    private http:HttpClient,
    private router: Router
) { }

  ngOnInit(): void {
    
    this.formValue = this.formbuilder.group({
      
      firstName: [''],
      lastName: [''],
      email: [''],
      password: [''],
      confirmPassword: ['']
    })
  }
  
  postUser(){
    
    
    this.RegistrationPageModelObject.firstName=this.formValue.value.firstName;
    this.RegistrationPageModelObject.lastName=this.formValue.value.lastName;
    this.RegistrationPageModelObject.email=this.formValue.value.email;
    this.RegistrationPageModelObject.password=this.formValue.value.password;
    this.RegistrationPageModelObject.confirmPassword=this.formValue.value.confirmPassword;
   
    this.api.postRegisteredUser(this.RegistrationPageModelObject)
    .subscribe(res=>{
      console.log(res);
      alert("added");
      this.router.navigate(['/']);
    },
    err=>{
      alert("User not registered. Please enter valid credentials");
    }
    )
  }


 
}
