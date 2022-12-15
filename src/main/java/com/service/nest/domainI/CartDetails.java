package com.service.nest.domainI;

import java.util.List;

public class CartDetails {

	private List<PriceDetails> serviceCost;

	private Double taxes;

	private Double grandTotal;

	public CartDetails() {
		super();
	}

	public CartDetails(List<PriceDetails> serviceCost, Double taxes, Double grandTotal) {
		super();
		this.serviceCost = serviceCost;
		this.taxes = taxes;
		this.grandTotal = grandTotal;
	}

	public List<PriceDetails> getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(List<PriceDetails> serviceCost) {
		this.serviceCost = serviceCost;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	public Double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

}
