package com.hamdibouallegue.stripe.model;

public class CheckoutPrice {
	private String stripePrice;
	private String name;
	private String currency;
	private long amount;
	private long quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getStripePrice() {
		return stripePrice;
	}

	public void setStripePrice(String stripePrice) {
		this.stripePrice = stripePrice;
	}
}
