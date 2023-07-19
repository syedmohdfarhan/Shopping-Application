import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/api-service/auth-service.service';
import { DataService } from '../../api-service/data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router :Router,private authService:AuthServiceService,private dataService:DataService) { }

  ngOnInit(): void {
  }

logout(){
this.authService.isLoggedIn=false;
this.dataService.setItems([]);
this.router.navigate(['/']);
}
}
