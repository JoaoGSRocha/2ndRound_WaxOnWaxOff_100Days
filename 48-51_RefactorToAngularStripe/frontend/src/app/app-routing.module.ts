import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductSingleComponent} from "./product-single/product-single.component";
import {ProductComponent} from "./product/product.component";
import {CheckoutComponent} from "./checkout/checkout.component";
import {CancelComponent} from "./cancel/cancel.component";
import {SuccessComponent} from "./success/success.component";

const routes: Routes = [
  {
    path: 'checkout',
    component: CheckoutComponent
  },
  {path: 'cancel', component: CancelComponent},
  {path: 'success', component: SuccessComponent},
  {
    path: 'product-single',
    component: ProductSingleComponent
  },
  {
    path: 'product',
    component: ProductComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
