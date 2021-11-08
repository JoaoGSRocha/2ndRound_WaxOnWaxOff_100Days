import {Component, Injectable} from '@angular/core';
import { HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Skin} from "../common/skin";
import {map} from "rxjs/operators";
import {Expansion} from "../common/expansion";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/skins';

  private expansionUrl = 'http://localhost:8080/expansion';

  constructor(private http: HttpClient) { }
  getProductList(): Observable<Skin[]>;
  getProductList(thisCategoryId: number): Observable<Skin[]>;
  getProductList(thisCategoryId: number, theUnitStock: number): Observable<Skin[]>;
  getProductList(theCategoryId?: number, stockMin?: number, stockMax?: number, priceMin?: number, priceMax?: number,
                 rarity?: string, condition?: string):
    Observable<Skin[]>;
  getProductList(theCategoryId?: number, stockMin?: number, stockMax?: number, priceMin?: number, priceMax?: number,
                 rarity?: string, condition?: string):
    Observable<Skin[]>  {
    let searchUrl = '';
    if(theCategoryId){
      searchUrl =
        `${this.baseUrl}/search/findByExpansionIdAndUnitsInStockBetweenAndPriceBetweenAndRarityContainingIgnoreCaseAndConditionContainingIgnoreCase?id=${theCategoryId}&stockMin=${stockMin}&stockMax=${stockMax}&price1=${priceMin}&price2=${priceMax}&rarity=${rarity}&condition=${condition}`;
    }
    else if(!theCategoryId && stockMax  && priceMax && rarity || rarity===""  && condition || condition===""){
      searchUrl = `${this.baseUrl}/search/findByUnitsInStockBetweenAndPriceBetweenAndRarityContainingIgnoreCaseAndConditionContainingIgnoreCase?stockMin=${stockMin}&stockMax=${stockMax}&price1=${priceMin}&price2=${priceMax}&rarity=${rarity}&condition=${condition}`;
    }

    else if(theCategoryId)
      searchUrl = `${this.baseUrl}/search/findByExpansionId?id=${theCategoryId}`;
    else if(priceMax || priceMax == 0)
      searchUrl = `${this.baseUrl}/search/findByPriceBetween?price1=${priceMin}&price2=${priceMax}`;
    else if(stockMax || stockMax == 0)
      searchUrl = `${this.baseUrl}/search/findByUnitsInStockBetween?stockMin=${stockMin}&stockMax=${stockMax}`;
    else if(rarity)
      searchUrl = `${this.baseUrl}/search/findByRarityContainingIgnoreCase?rarity=${rarity}`;
    else if(condition)
      searchUrl = `${this.baseUrl}/search/findByConditionContainingIgnoreCase?condition=${condition}`;
    else
      searchUrl = `${this.baseUrl}/search/findByExpansionIdAndUnitsInStockLessThanEqual?id=${theCategoryId}
        &units_in_stock=${stockMin}`;

    return this.http.get<GetResponseSkins>(searchUrl).pipe(
      map(response => response._embedded.skins)
    )
  }


  getProductExpansions(): Observable<Expansion[]>{
    return this.http.get<GetResponseExpansion>(this.expansionUrl).pipe(
      map(response => response._embedded.expansion)
    )
  }
}

interface GetResponseSkins {
  _embedded: {
    skins: Skin[];
  }
}

interface GetResponseExpansion {
  _embedded: {
    expansion: Expansion[];
  }
}
