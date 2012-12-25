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
@Table(name="impBillGoods")
@Searchable
@Audited

public class ImpBillGoods extends BaseObject implements Serializable{
 private static final long serialVersionUID = 3832626162173359411L;
	  
	private Long id;
	private String equipment;						//required
	private String commodity;
	private ImpBill bill;						//required
	private Integer quantity;						//required
	private Double weight;
	private Double measurement;
	private String description;
	
		
	public ImpBillGoods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImpBillGoods(final String equipment, ImpBill bill, String commodity) {
		super();
		this.equipment = equipment;
		this.bill = bill;		
		this.commodity = commodity;	
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

	public String getEquipment() {
		return equipment;
	}

	/**
	 * @return the bill
	 */
	@ManyToOne
	@JoinColumn(name="bill_id")	
	public ImpBill getBill() {
		return bill;
	}

	/**
	 * @return the order
	 */
	@Column(nullable=false)
	public Integer getPartyNo() {
		return quantity;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @param vessel the vessel to set
	 */
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(ImpBill bill) {
		this.bill = bill;
	}

	/**
	 * @param order the order to set
	 */
	public void setPartyNo(Integer partyNo) {
		this.quantity = partyNo;
	}
	
	public String getCommodity() {
		return commodity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getMeasurement() {
		return measurement;
	}

	public String getDescription() {
		return description;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setMeasurement(Double measurement) {
		this.measurement = measurement;
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
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
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
		ImpBillGoods other = (ImpBillGoods) obj;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (bill == null) {
			if (other.bill != null)
				return false;
		} else if (!bill.equals(other.bill))
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BillGoods [id=" + id + ", equipment=" + equipment + ", bill=" + bill
				+ ", quantity=" + quantity  + "]";
	}
}