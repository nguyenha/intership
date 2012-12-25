package com.home.qh.model;

import java.io.Serializable;

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
@Table(name="shippingInstr")
@Searchable
@Audited

public class ShippingInstr extends BaseObject implements Serializable{
 private static final long serialVersionUID = 3832626162173359411L;
	  
	private Long id;					
	private String toAddress;
	private String fromAddress;
	private String freightPlaceCode;
	private String freightPlaceType;
	private String description;
	
	private Booking booking;	
	private Paying paying;
		
	public ShippingInstr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShippingInstr(final Booking booking) {
		super();		
	//	this.booking = booking;		
		
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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name="paying_id")
	public Paying getPaying() {
		return paying;
	}

	public void setPaying(Paying paying) {
		this.paying = paying;
	}

	
	
	public String getToAddress() {
		return toAddress;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public String getFreightPlaceCode() {
		return freightPlaceCode;
	}

	public String getFreightPlaceType() {
		return freightPlaceType;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public void setFreightPlaceCode(String freightPlaceCode) {
		this.freightPlaceCode = freightPlaceCode;
	}

	public void setFreightPlaceType(String freightPlaceType) {
		this.freightPlaceType = freightPlaceType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
	//	result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		
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
		ShippingInstr other = (ShippingInstr) obj;
//		if (booking == null) {
//			if (other.booking != null)
//				return false;
//		} else if (!booking.equals(other.booking))
//			return false;
		
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShippingInstr [id=" + id  + "]";
	}
}