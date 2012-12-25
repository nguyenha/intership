package com.home.qh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.compass.annotations.Searchable;

@Embeddable
@Searchable(root = false)
public class PurchaseInfo extends BaseObject implements Serializable {
    private static final Log log = LogFactory.getLog(CommonCode.class);
    private static final long serialVersionUID = -1393312947037639590L;
	
	private CommonCode pricing;
	private Double discount;
	private CommonCode paymentTerm;
	private String taxing;
	
	/*
	 * Currency
	 */
	@ManyToOne
	@JoinColumn(name="currency_code")
	public CommonCode getPricing() {
		return pricing;
	}

	@Column
	public Double getDiscount() {
		return discount;
	}

	@ManyToOne
	@JoinColumn(name="payment_term_code")
	public CommonCode getPaymentTerm() {
		return paymentTerm;
	}

	@Column
	public String getTaxing() {
		return taxing;
	}

	public void setTaxing(String taxing) {
		this.taxing = taxing;
	}

	public void setPricing(CommonCode pricing) {
		this.pricing = pricing;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void setPaymentTerm(CommonCode paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
