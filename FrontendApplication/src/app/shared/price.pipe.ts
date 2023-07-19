import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'price'
})
export class PricePipe implements PipeTransform {

  transform(value:any,searchTerm:any): any {
    const arr: any[]= value.filter(function(search:any){
      
      console.log(search.id);
    
    return search.price<=searchTerm 
    
    }); 
    if(arr.length==0){
      return value;
    }
    else {
      return arr;
    }
  }

}
