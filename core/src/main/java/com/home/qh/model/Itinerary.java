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
@Table(name="itinerary")
@Searchable
@Audited

public class Itinerary extends BaseObject implements Serializable{
 private static final long serialVersionUID = 3832626162173359411L;
	  
	private Long id;
	private Voyage voyage;						//required
	private Port port;							//required
	private Integer visitOrder;						//required
	private Date arrivalInScheduled;
	private Date departureInScheduled;
	private Date arrivalInFact;
	private Date departureInFact;
	
	public Itinerary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Itinerary(final Integer visitOrder, Voyage voyage, Port port) {
		super();
		this.voyage = voyage;
		this.port = port;
		this.visitOrder = visitOrder;
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
	@JoinColumn(name="voyage_id")	
	public Voyage getVoyage() {
		return voyage;
	}



	/**
	 * @return the port
	 */
	@ManyToOne
	@JoinColumn(name="port_id")	
	public Port getPort() {
		return port;
	}



	/**
	 * @return the order
	 */
	@Column(nullable=false)
	public Integer getVisitOrder() {
		return visitOrder;
	}



	/**
	 * @return the comingInScheduled
	 */
	@Column(nullable=true)
	public Date getArrivalInScheduled() {
		return arrivalInScheduled;
	}



	/**
	 * @return the leavingInScheduled
	 */
	@Column(nullable=true)
	public Date getDepartureInScheduled() {
		return departureInScheduled;
	}



	/**
	 * @return the comingInFact
	 */
	@Column(nullable=true)
	public Date getArrivalInFact() {
		return arrivalInFact;
	}



	/**
	 * @return the leavingInFact
	 */
	@Column(nullable=true)
	public Date getDepartureInFact() {
		return departureInFact;
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
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}



	/**
	 * @param port the port to set
	 */
	public void setPort(Port port) {
		this.port = port;
	}



	/**
	 * @param order the order to set
	 */
	public void setVisitOrder(Integer visitOrder) {
		this.visitOrder = visitOrder;
	}



	/**
	 * @param comingInScheduled the comingInScheduled to set
	 */
	public void setArrivalInScheduled(Date arrivalInScheduled) {
		this.arrivalInScheduled = arrivalInScheduled;
	}



	/**
	 * @param leavingInScheduled the leavingInScheduled to set
	 */
	public void setDepartureInScheduled(Date departureInScheduled) {
		this.departureInScheduled = departureInScheduled;
	}



	/**
	 * @param comingInFact the comingInFact to set
	 */
	public void setArrivalInFact(Date arrivalInFact) {
		this.arrivalInFact = arrivalInFact;
	}



	/**
	 * @param leavingInFact the leavingInFact to set
	 */
	public void setDepartureInFact(Date departureInFact) {
		this.departureInFact = departureInFact;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((visitOrder == null) ? 0 : visitOrder.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((voyage == null) ? 0 : voyage.hashCode());
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
		Itinerary other = (Itinerary) obj;
		if (visitOrder == null) {
			if (other.visitOrder != null)
				return false;
		} else if (!visitOrder.equals(other.visitOrder))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (voyage == null) {
			if (other.voyage != null)
				return false;
		} else if (!voyage.equals(other.voyage))
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Itinerary [id=" + id + ", voyage=" + voyage + ", port=" + port
				+ ", visitOrder=" + visitOrder + ", arrivalInScheduled="
				+ arrivalInScheduled + ", departureInScheduled="
				+ departureInScheduled + ", arrivalInFact=" + arrivalInFact
				+ ", departureInFact=" + departureInFact + "]";
	}
}