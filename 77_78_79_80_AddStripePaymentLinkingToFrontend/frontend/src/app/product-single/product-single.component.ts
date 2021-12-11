import {Component, Injectable, OnInit} from '@angular/core';
import { HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Skin} from "../common/skin";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-product-single',
  templateUrl: './product-single.component.html',
  styleUrls: ['./product-single.component.css']
})

@Injectable({
  providedIn: 'root'
})
export class ProductSingleComponent implements OnInit {

    private baseUrl = 'http://localhost:8080/api/skin';

  // @ts-ignore
  public totalAngularPackages;

  public name="";
  public condition="";

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    // Simple GET request with response type <any>
    this.http.get<any>('http://localhost:8080/skins').subscribe(data => {
      this.totalAngularPackages = data._embedded.skins;
    })
  }

  getProductList(theCategoryId: number): Observable<Skin[]>  {
    const searchUrl = `${this.baseUrl}/search/findByExpansionId?id=${theCategoryId}`

    return this.http.get<GetResponse>(searchUrl).pipe(
      map(response => response._embedded.skins)
    )
  }
}

interface GetResponse {
  _embedded: {
    skins: Skin[];
  }
}
