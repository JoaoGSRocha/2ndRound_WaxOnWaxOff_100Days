package com.hamdibouallegue.stripe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hamdibouallegue.stripe.model.CheckoutPrice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hamdibouallegue.stripe.model.Checkout;
import com.hamdibouallegue.stripe.model.CheckoutPayment;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@RestController
@RequestMapping(value = "/stripe")
public class StripeController {
	private static Gson gson = new Gson();

	@PostMapping("/payment")
	/**
	 * Payment with Stripe checkout page
	 * 
	 * @param payment
	 * @return
	 * @throws StripeException
	 */
	//Next iteration is me having a payments[]  iterate for each payment Object to add them to add
	//each one to the LineItems .addLineItem(...)S
	public String paymentWithCheckoutPage(@RequestBody CheckoutPayment payment) throws StripeException {
		// We initilize stripe object with the api key
		init();
		SessionCreateParams params = SessionCreateParams.builder().build();
		List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();
		for (CheckoutPrice price : payment.getPrices()) {
			if(price.getStripePrice() != null)
				lineItems.add(SessionCreateParams.LineItem.builder().setQuantity(price.getQuantity())
						.setPrice(price.getStripePrice())
						.build());
			else{
				lineItems.add(SessionCreateParams.LineItem.builder().setQuantity(price.getQuantity())
						.setPriceData(
								SessionCreateParams.LineItem.PriceData.builder()
										.setCurrency(price.getCurrency()).setUnitAmount(price.getAmount())
										.setProductData(SessionCreateParams.LineItem.PriceData.ProductData
												.builder().setName(price.getName()).build())
										.build())
						.build());
			}
		}
		params = SessionCreateParams.builder()
				// We will use the credit card payment method
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(payment.getSuccessUrl())
				.setCancelUrl(
						payment.getCancelUrl())
				.addAllLineItem(lineItems)
				.build();

		Session session = Session.create(params);

		Map<String, String> responseData = new HashMap<>();
		responseData.put("id", session.getId());

		return gson.toJson(responseData);
	}

	@PostMapping("/subscription")
	/**
	 * Used to create a subscription with strpe checkout page
	 * 
	 * @param checkout
	 * @return the subscription id
	 * @throws StripeException
	 */
	public String subscriptionWithCheckoutPage(@RequestBody Checkout checkout) throws StripeException {
		SessionCreateParams params = new SessionCreateParams.Builder().setSuccessUrl(checkout.getSuccessUrl())
				.setCancelUrl(checkout.getCancelUrl()).addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.setMode(SessionCreateParams.Mode.SUBSCRIPTION).addLineItem(new SessionCreateParams.LineItem.Builder()
						.setQuantity(1L).setPrice(checkout.getPriceId()).build())
				.build();

		try {
			Session session = Session.create(params);
			Map<String, Object> responseData = new HashMap<>();
			responseData.put("sessionId", session.getId());
			return gson.toJson(responseData);
		} catch (Exception e) {
			Map<String, Object> messageData = new HashMap<>();
			messageData.put("message", e.getMessage());
			Map<String, Object> responseData = new HashMap<>();
			responseData.put("error", messageData);
			return gson.toJson(responseData);
		}
	}

	private static void init() {
		Stripe.apiKey = "sk_test_1YMyz3phMdCvwWgXjVBdTAi0001ZvknJmk";
	}
}
