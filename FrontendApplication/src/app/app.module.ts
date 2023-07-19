import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { HttpClientModule } from '@angular/common/http';
import { ResultPageComponent } from './dashboard/result-page/result-page.component';

import { ProductDetailsComponent } from './dashboard/product-details/product-details.component';


import { HeaderComponent } from './dashboard/header/header.component';
import { FooterComponent } from './dashboard/footer/footer.component';
 import { FilterPipePipe } from './shared/filter-pipe.pipe';
//  import { SearchBarComponent } from './dashboard/search-bar/search-bar.component';
import { IdPipe } from './shared/id.pipe';
import { PricePipe } from './shared/price.pipe';
import { PriceminPipe } from './shared/pricemin.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    RegistrationPageComponent,
    ResultPageComponent,
   
    ProductDetailsComponent,
    
   
    HeaderComponent,
    FooterComponent,
     FilterPipePipe,
    // SearchBarComponent,
    IdPipe,
    PricePipe,
    PriceminPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
