import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'id'
})
export class IdPipe implements PipeTransform {

  
  transform(value:any,searchTerm:number):any {

    const arr: any[]= value.filter(function(search:any){
      
      
    
    return search.id==searchTerm
    
    }); 
    if(arr.length==0){
      return value;
    }
    else {
      return arr;
    }
  }
  

}
