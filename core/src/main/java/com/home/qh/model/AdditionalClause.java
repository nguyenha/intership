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
@Table(name="additionalClause")
@Searchable
@Audited

public class AdditionalClause extends BaseObject implements Serializable{
 private static final long serialVersionUID = 3832626162173359411L;
	  
	private Long id;
	private Clause clause;						//required
	private Booking booking;						//required
	private Integer clauseNo;						//required
	
		
	public AdditionalClause() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdditionalClause(final Integer clauseNo, Clause clause, Booking booking) {
		super();
		this.clause = clause;
		this.booking = booking;
		this.clauseNo = clauseNo;
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
	@JoinColumn(name="clause_id")	
	public Clause getClause() {
		return clause;
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
	public Integer getClauseNo() {
		return clauseNo;
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
	public void setClause(Clause clause) {
		this.clause = clause;
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
	public void setClauseNo(Integer clauseNo) {
		this.clauseNo = clauseNo;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clauseNo == null) ? 0 : clauseNo.hashCode());
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((clause == null) ? 0 : clause.hashCode());
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
		AdditionalClause other = (AdditionalClause) obj;
		if (clauseNo == null) {
			if (other.clauseNo != null)
				return false;
		} else if (!clauseNo.equals(other.clauseNo))
			return false;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (clause == null) {
			if (other.clause != null)
				return false;
		} else if (!clause.equals(other.clause))
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransParty [id=" + id + ", clause=" + clause + ", booking=" + booking
				+ ", clauseNo=" + clauseNo  + "]";
	}
}