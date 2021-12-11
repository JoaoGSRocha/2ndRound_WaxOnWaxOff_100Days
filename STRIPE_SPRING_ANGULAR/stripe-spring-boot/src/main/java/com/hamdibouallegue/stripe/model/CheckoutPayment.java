package com.hamdibouallegue.stripe.model;

import java.util.List;

public class CheckoutPayment {
	private List<CheckoutPrice> prices;
	private String successUrl;
	private String cancelUrl;

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getCancelUrl() {
		return cancelUrl;
	}

	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
	}

	public List<CheckoutPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<CheckoutPrice> prices) {
		this.prices = prices;
	}
}
