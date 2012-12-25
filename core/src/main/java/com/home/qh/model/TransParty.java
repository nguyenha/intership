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
@Table(name="transParty")
@Searchable
@Audited

public class TransParty extends BaseObject implements Serializable{
 private static final long serialVersionUID = 3832626162173359411L;
	  
	private Long id;
	private Customer customer;						//required
	private Booking booking;						//required
	private Integer partyNo;						//required
	private Boolean confirmed;
	
		
	public TransParty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransParty(final Integer partyNo, Customer customer, Booking booking) {
		super();
		this.customer = customer;
		this.booking = booking;
		this.partyNo = partyNo;
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
	@JoinColumn(name="customer_id")	
	public Customer getCustomer() {
		return customer;
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
		return partyNo;
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
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		this.partyNo = partyNo;
	}

	
	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partyNo == null) ? 0 : partyNo.hashCode());
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
		TransParty other = (TransParty) obj;
		if (partyNo == null) {
			if (other.partyNo != null)
				return false;
		} else if (!partyNo.equals(other.partyNo))
			return false;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransParty [id=" + id + ", customer=" + customer + ", booking=" + booking
				+ ", partyNo=" + partyNo  + "]";
	}
}