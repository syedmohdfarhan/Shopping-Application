import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterPipe'
})
export class FilterPipePipe implements PipeTransform {

  transform(value:any,searchTerm:any):any {
    return value.filter(function(search:any){
     // return search.brand.equalsIgnoreCase(searchTerm);
    return search.brand.indexOf(searchTerm.toLowerCase())>-1
    }); 
    
  }
  
}
