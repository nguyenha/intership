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
@Table(name="transGoodsDesc")
@Searchable
@Audited

public class TransGoodsDesc extends BaseObject implements Serializable{
 private static final long serialVersionUID = 3832626162173359411L;
	  
	private Long id;
	private Equipment equipment;						//required
	private Commodity commodity;
	private Booking booking;						//required
	private Integer quantity;						//required
	private Double weight;
	private Double measurement;
	private String sealNo;
	private String description;
	
	private KindPackage kindPackage;
	private CtrKindPackage ctrKindPackage;
	
		
	public TransGoodsDesc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransGoodsDesc(final Equipment equipment, Booking booking, Commodity commodity) {
		super();
		this.equipment = equipment;
		this.booking = booking;		
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


	@ManyToOne
	@JoinColumn(name="equipment_id")	
	public Equipment getEquipment() {
		return equipment;
	}



	/**
	 * @return the booking
	 */
	@ManyToOne
	@JoinColumn(name="booking_id")	
	public Booking getBooking() {
		return booking;
	}



	/**
	 * @return the order
	 */
	@Column(nullable=false)
	public Integer getPartyNo() {
		return quantity;
	}

		
	public String getSealNo() {
		return sealNo;
	}

	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
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
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * @param order the order to set
	 */
	public void setPartyNo(Integer partyNo) {
		this.quantity = partyNo;
	}

	@ManyToOne
	@JoinColumn(name="commodity_id")
	public Commodity getCommodity() {
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

	public void setCommodity(Commodity commodity) {
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

	@ManyToOne
	@JoinColumn(name="kindPackage_id")	
	public KindPackage getKindPackage() {
		return kindPackage;
	}

	public void setKindPackage(KindPackage kindPackage) {
		this.kindPackage = kindPackage;
	}
	
	@ManyToOne
	@JoinColumn(name="ctrKindPackage_id")	
	public CtrKindPackage getCtrKindPackage() {
		return ctrKindPackage;
	}

	public void setCtrKindPackage(CtrKindPackage ctrKindPackage) {
		this.ctrKindPackage = ctrKindPackage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
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
		TransGoodsDesc other = (TransGoodsDesc) obj;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
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
		return "TransGoodsDesc [id=" + id + ", equipment=" + equipment + ", booking=" + booking
				+ ", quantity=" + quantity  + "]";
	}
}