import { Component, OnInit } from '@angular/core';
import {Skin} from "../common/skin";
import {ProductService} from "../services/product.service";
import {ActivatedRoute} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {LabelType, Options} from '@angular-slider/ngx-slider';
import {MatRadioModule} from '@angular/material/radio';
import {FormBuilder, FormGroup, ReactiveFormsModule} from '@angular/forms';
import { FormControl } from '@angular/forms';
import {Expansion} from "../common/expansion";
import {ModalService} from "../_modal";

// @ts-ignore
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  shopForm: any;
  minValue: any = 0;
  selectedValue: any = "";
  maxValue: any = 40;
  rarity: string = "";
  condition: string = "";
  expansions: Expansion[] = [];
  priceOptions: Options = {
    floor: 0,
    ceil: 40,
    translate: (value: number, label: LabelType): string => {
      switch (label) {
        case LabelType.Low:
          return "<b>Min price:</b> $" + value;
        case LabelType.High:
          return "<b>Max price:</b> $" + value;
        default:
          return "$" + value;
      }
    }
  };

  name = new FormControl('');
  rarityFB = this.fb.group({
    rarity: ['']
  });
  conditionFB = this.fb.group({
    condition: ['']
  });

  skins: Skin[] = [];
  a: any[] = [];
  course_onCart: any[] = [];
  cart_final: any[] = [];
  cart_and_quantity: any[][] = [];
  currentExpansionId: any = null;
  stripe_prices_ids: Array<string> = [];
  stripe_prices_quant: number = 0;
  minStock: any = 0;
  maxStock: any = 300;
  stockOptions: Options = {
    floor: 0,
    ceil: 300,
    translate: (value: number, label: LabelType): string => {
      switch (label) {
        case LabelType.Low:
          return "<b>Min Stock Units:</b> " + value;
        case LabelType.High:
          return "<b>Max Stock Units:</b> " + value;
        default:
          return "" + value;
      }
    }
  };
  // @ts-ignore
  public totalAngularPackages;

  bodyText: string = "";

  constructor(private fb: FormBuilder, private productService: ProductService,
              private route: ActivatedRoute, private http: HttpClient,
              private modalService: ModalService) {
  }

  onlyUnique(value: number, index: number, self: any) {
    return self.indexOf(value) === index;
  }
  addToCart(course: Skin) {
    this.course_onCart.push(course);
    // @ts-ignore
    this.a = [...new Set(this.course_onCart.map(item => item.stripe_price))];
    let c = this.course_onCart;
    this.a.forEach(function(ele, index, theArray) {
        //ele.count = 0;
      c.forEach(function (duplicate_ele) {
        let count = 0;
        if(theArray[index].count !== undefined)
          count = theArray[index].count;
        if(duplicate_ele.stripe_price === ele)
          theArray[index] = duplicate_ele;
        if(theArray[index].count !== undefined)
          theArray[index].count = count;
        if(theArray[index].stripe_price === duplicate_ele.stripe_price) {
          if(theArray[index].count !== undefined)
            theArray[index].count++;
          else
            theArray[index].count = 1;
        }
      });
    });
    console.log(this.a);
  }

  resetExpansion() {
    this.currentExpansionId = 0;
    this.listProducts();
  }

  resetRarity() {
    this.rarity = '';
    this.rarityFB.controls.rarity.patchValue('');
    this.listProducts()
  }

  resetCondition() {
    this.condition = '';
    this.conditionFB.controls.condition.patchValue('');
    this.listProducts()
  }

  ngOnInit(): void {
    this.bodyText = 'This text can be updated in modal 1';
    this.route.paramMap.subscribe(() => {
      this.listProducts();
      this.listExpansions();
    });

    // Simple GET request with response type <any>
    this.http.get<any>('http://localhost:8080/skins').subscribe(data => {
      this.totalAngularPackages = data._embedded.skins;
    })

    this.http.get<any>('http://localhost:8080/expansion').subscribe(data => {
      this.totalAngularPackages = data._embedded.expansion;
    })
  }


  clearSortingFilters(){
    this.selectedValue = null; // or false or ''
  }

  resetForm(){
    this.shopForm.reset()
    this.minValue = 0;
    this.maxValue = 40;
    this.rarity = "";
    this.condition = "";
    this.currentExpansionId = 0;
    this.minStock = 0;
    this.maxStock = 300;
  }

  listProducts() {
    // check if 'id' parameter is available
    const hasExpansionId: boolean = (this.currentExpansionId !== null);
    const hasStockMin: boolean = this.route.snapshot.paramMap.has("stockMin");
    const hasStockMax: boolean = this.route.snapshot.paramMap.has("stockMax");
    const hasMinPrice: boolean = this.route.snapshot.paramMap.has("price1");
    const hasMaxPrice: boolean = this.route.snapshot.paramMap.has("price2");
    const hasRarity: boolean = this.route.snapshot.paramMap.has("rarity");
    const hasCondition: boolean = this.route.snapshot.paramMap.has("condition");

    if(!hasExpansionId) {
      this.currentExpansionId = 0;
    }
    if(hasStockMax) {
      // @ts-ignore
      this.maxStock = +this.route.snapshot.paramMap.get('stockMax');
    }

    // now get the skins for the given expansion id
    this.productService.getProductList(this.currentExpansionId, this.minStock, this.maxStock,
      this.minValue, this.maxValue, this.rarity, this.condition).subscribe(
      data => {
        this.skins = data;
      }
    )
  }

  listExpansions() {
    this.productService.getProductExpansions().subscribe(
      data => {
        console.log('Product Categories=' + JSON.stringify(data));
        this.expansions = data;
        this.listProducts();
      }
    )
  }

  openModal(id: string) {
    this.modalService.open(id);
  }

  closeModal(id: string) {
    this.modalService.close(id);
  }
}
