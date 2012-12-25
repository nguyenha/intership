package com.home.qh.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="transFreight")
@Searchable
@Audited

public class TransFreight extends BaseObject implements Serializable{
 private static final long serialVersionUID = 3832626162173359411L;
	  
	private Long id;
	private Fee fee;						//required
	private Booking booking;					//required
	private Double amount;						//required
	private Boolean payed;
	private Date payedDate;
	private String description;
		
	public TransFreight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransFreight(final Fee fee, Booking booking) {
		super();
		this.fee = fee;
		this.booking = booking;
		
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
	@JoinColumn(name="fee_id")	
	public Fee getFee() {
		return fee;
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
	public Double getAmount() {
		return amount;
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
	public void setFee(Fee fee) {
		this.fee = fee;
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
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	public Boolean getPayed() {
		return payed;
	}

	public void setPayed(Boolean payed) {
		this.payed = payed;
	}
	
	public Date getPayedDate() {
		return payedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setPayedDate(Date payedDate) {
		this.payedDate = payedDate;
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
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((fee == null) ? 0 : fee.hashCode());
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
		TransFreight other = (TransFreight) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (fee == null) {
			if (other.fee != null)
				return false;
		} else if (!fee.equals(other.fee))
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransFreight [id=" + id + ", fee=" + fee + ", booking=" + booking
				+ ", amount=" + amount  + "]";
	}
}