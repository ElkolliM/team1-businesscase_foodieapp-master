import { Pipe, PipeTransform } from '@angular/core';
import { Restaurant } from './models/Restaurant';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(restaurants: any, searchText: any): any {
    if(restaurants == false) return [];  //
    if(searchText== false) return restaurants;  //

    
    if (searchText !== undefined){ 
    searchText =  searchText.toLowerCase();
    

    return restaurants.filter( function(item:any){ return JSON.stringify(item).toLowerCase().includes(searchText); });

    }
   // return contacts;
  }


}
