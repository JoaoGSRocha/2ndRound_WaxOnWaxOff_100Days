import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { loadStripe } from '@stripe/stripe-js';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css'],
})
export class CheckoutComponent {
  // We load  Stripe
  stripePromise = loadStripe(environment.stripe);
  constructor(private http: HttpClient) {}

  async pay(): Promise<void> {
    // here we create a payment object
    const payment = {
    prices: [
      {
        price: "price_1JF9EXH8eh00DPhbjBnLUU0K",
        quantity: '1',
        currency: 'eur'
      },
      {
        name: 'Iphone',
        currency: 'eur',
        // amount on cents *10 => to be on dollar
        amount: 99900,
        quantity: '1',
      },

      {
        name: 'Android X',
        currency: 'eur',
        // amount on cents *10 => to be on dollar
        amount: 300,
        quantity: '2',
      }
    ],
      cancelUrl: 'http://localhost:4200/cancel',
      successUrl: 'http://localhost:4200/success',
    };

    const stripe = await this.stripePromise;

    // this is a normal http calls for a backend api
    this.http
      .post(`${environment.serverUrl}/payment`, payment)
      .subscribe((data: any) => {
        // I use stripe to redirect To Checkout page of Stripe platform
        // @ts-ignore
        stripe.redirectToCheckout({
          sessionId: data.id,
        });
      });
  }
}
