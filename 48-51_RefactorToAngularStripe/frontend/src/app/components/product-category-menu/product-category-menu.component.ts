import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Skin} from "../../common/skin";
import {map} from "rxjs/operators";
import {Expansion} from "../../common/expansion";
import {ProductService} from "../../services/product.service";

@Component({
  selector: 'app-product-category-menu',
  templateUrl: './product-category-menu.component.html',
  styleUrls: ['./product-category-menu.component.css']
})
export class ProductCategoryMenuComponent implements OnInit {


  expansions: Expansion[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.listExpansions();
  }

  listExpansions() {
    this.productService.getProductExpansions().subscribe(
      data => {
        console.log('Product Categories=' + JSON.stringify(data));
        this.expansions = data;
      }
    )
  }
}
