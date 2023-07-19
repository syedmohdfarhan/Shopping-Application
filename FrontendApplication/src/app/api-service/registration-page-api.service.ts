import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class RegistrationPageApiService {
  private URL:string=environment.url;
  constructor(private http:HttpClient) { }
  
  postRegisteredUser(data:any){
   
    return this.http.post<any>("http://localhost:5050/adduser", data)
    .pipe(map((res: any) => {
      return res;
    }))
  }
}
