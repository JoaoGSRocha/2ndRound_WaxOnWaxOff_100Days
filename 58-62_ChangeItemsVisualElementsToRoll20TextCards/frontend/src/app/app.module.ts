import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductSingleComponent } from './product-single/product-single.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ProductComponent } from './product/product.component';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import {RouterModule, Routes} from "@angular/router";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxSliderModule} from "@angular-slider/ngx-slider";
import {MatRadioModule} from '@angular/material/radio';
import { CancelComponent } from './cancel/cancel.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { MatCardModule } from '@angular/material/card';
import {MatButtonModule} from "@angular/material/button";
import { SuccessComponent } from './success/success.component';


const routes: Routes = [
  {path: 'expansion/:id', component: ProductComponent},
  {path: 'expansion', component: ProductComponent},
  {path: 'skin', component: ProductComponent},
  {path: '', redirectTo: '/skins', pathMatch: 'full'},
  {path: '**', redirectTo: '/skins', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ProductSingleComponent,
    ProductComponent,
    ProductCategoryMenuComponent,
    CancelComponent,
    SuccessComponent,
    CheckoutComponent,
  ],
    imports: [
        RouterModule.forRoot(routes),
        BrowserModule,
        // import HttpClientModule after BrowserModule.
        HttpClientModule,
        AppRoutingModule,
        FormsModule,
        BrowserAnimationsModule,
        NgxSliderModule,
        ReactiveFormsModule,
        MatRadioModule,
        MatCardModule,
        MatButtonModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
