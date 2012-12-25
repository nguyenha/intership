package com.home.qh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.hibernate.envers.Audited;


@Entity
@Table(name="billFreight")
@Searchable
@Audited

public class BillFreight extends BaseObject implements Serializable{
 private static final long serialVersionUID = 3832626162173359411L;
	  
	private Long id;
	private String feeType;						//required
	private Bill bill;					//required
	private String amount;						//required	
	private String description;
		
	public BillFreight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillFreight(final String feeType, Bill bill) {
		super();
		this.feeType = feeType;
		this.bill = bill;
		
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	public Long getId() {
		return id;
	}


	/**
	 * @return the bill
	 */
	@ManyToOne
	@JoinColumn(name="bill_id")	
	public Bill getBill() {
		return bill;
	}

	/**
	 * @return the order
	 */
	@Column(nullable=false)
	public String getAmount() {
		return amount;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	/**
	 * @param order the order to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
		result = prime * result + ((feeType == null) ? 0 : feeType.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillFreight other = (BillFreight) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (bill == null) {
			if (other.bill != null)
				return false;
		} else if (!bill.equals(other.bill))
			return false;
		if (feeType == null) {
			if (other.feeType != null)
				return false;
		} else if (!feeType.equals(other.feeType))
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BillFreight [id=" + id + ", fee=" + feeType + ", bill=" + bill
				+ ", amount=" + amount  + "]";
	}
}