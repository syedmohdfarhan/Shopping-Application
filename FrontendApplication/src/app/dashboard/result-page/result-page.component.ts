import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { DataService } from '../../api-service/data.service';

@Component({
  selector: 'app-result-page',
  templateUrl: './result-page.component.html',
  styleUrls: ['./result-page.component.css']
})
export class ResultPageComponent implements OnInit {

public data!:string;
  searchKey:string="";
  searchKey2!:number;
  searchKey3!:number;
   searchKey4!:number;
  constructor(private dataService:DataService, private http:HttpClient,private router: Router) { }

  public ItemList:any=[];
  ngOnInit(): void {
    
    this.ItemList=this.dataService.getItems();
    console.log(this.ItemList);

  }
  
  getProducts(){
    console.log(this.data);
     this.dataService.getAllData(this.data).subscribe(res=>{
       console.log("Inside Scubsccribe");
      this.router.navigate(['/resultPage'])
       return res},
       (err)=>{
        alert("Sorry this product is unavailable");
      }
       )
       
       ;
      
  }
  
    
    }
