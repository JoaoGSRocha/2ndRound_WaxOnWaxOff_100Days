import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductSingleComponent} from "./product-single/product-single.component";
import {ProductComponent} from "./product/product.component";
import {StripeCheckoutComponent} from "./stripe-checkout/stripe-checkout.component";
import {ModalComponent} from "./_modal/modal.component";

const routes: Routes = [
  {
    path: 'product-single',
    component: ProductSingleComponent
  },
  {
    path: 'product',
    component: ProductComponent
  },
  {
    path: 'modal',
    component: ModalComponent
  },
  {
    path: 'stripe-checkout',
    component: StripeCheckoutComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
