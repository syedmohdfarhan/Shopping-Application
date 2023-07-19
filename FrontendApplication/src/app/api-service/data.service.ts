import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
 import { BehaviorSubject } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DataService {
private Items:any=[];
  
  constructor(private http:HttpClient) { }
  

getItems(){
  return this.Items;
}
setItems(item:any){
  this.Items=item;
}





  getAllData(data:string){   
    return this.http.get<any>('http://localhost:5050/getAllProductsByName/'+data)
    .pipe(map((res: any) => {
      this.setItems(res);
      return res;
    }))
  }
 
  checkPinCode(id:number,pin:any){
    return this.http.get<any>(`http://localhost:5050/isDeliverable/`+id+"/"+pin)
    .pipe(map((data: any) => {
      console.log(data);
        return data;
    }));
  }





  
}
