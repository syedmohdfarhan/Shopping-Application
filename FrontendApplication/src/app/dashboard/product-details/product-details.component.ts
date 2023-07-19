import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthResponse } from 'src/app/model/authResponse-model';
import { DataService } from '../../api-service/data.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  public data!:number;
  
  public ItemData!:any;
  public noOfDays=Math.floor(Math.random() * (9 - 2 + 1)) + 2;
  constructor(private activatedRoute:ActivatedRoute,private dataService:DataService) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params)=>{
      this.ItemData=this.dataService.getItems().filter((item: { id: number; })=> item.id==params['id'])[0];
    });
  }
  checkAvailability(){
    this.dataService.checkPinCode(this.ItemData.id,this.data).subscribe( (res:AuthResponse)=>{
      console.log(res);
      
      if(res.status==="success"&& res.status_code===200)
        {
          alert(`Yes the product is available for this pincode and it will be delivered in ${this.noOfDays} days` );
          
        }
        
    },
    (err)=>{
      alert("Temporarily unavailable for this location");
    }
    );
  }

}
