import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { LoginModel } from '../model/login-model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  //private URL:string=environment.url;
  constructor(private http:HttpClient) { }
  
 login(data:LoginModel) {
    return this.http.post<any>(`http://localhost:5050/authenticateUser`,data)
        .pipe(map((user: any) => {
            localStorage.setItem('currentUser', JSON.stringify(user));
            return user;
        }));
 }

}
