package com.home.qh.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.hibernate.envers.Audited;

/**
 * This class represents the basic "custRequire" object in AppFuse that allows for authentication
 * and user management.  It implements Acegi Security's UserDetails interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *         Updated by Dan Kibler (dan@getrolling.com)
 *         Extended to implement Acegi UserDetails interface
 *         by David Carter david@carter.net
 */
@Entity
@Table(name = "custRequire")
@Searchable
@Audited

public class CustRequire extends BaseObject implements Serializable {
    private static final long serialVersionUID = 3832626162173359411L;

    private Long id;
 //   private Booking booking;                    // required
    private String status;   
    private String title;
    private String description;                    // required
    private String bookingCode; 
    
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public CustRequire() {
    }

    /**
     * Create a new instance and set the code, name.
     *
     * @param code of custRequire.
     * @param name of custRequire.
     */
    public CustRequire(final Booking booking) {
     //   this.booking = booking;
       
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
		this.id = id;
	}
    
  

	public String getTitle() {
		return title;
	}

	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}
	
	public String getBookingCode() {
		return bookingCode;
	}

	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
//	@ManyToOne
//    @JoinColumn(name="booking_id")
//	public Booking getBooking() {
//		return booking;
//	}
//	
//	public void setBooking(Booking booking) {
//		this.booking = booking;
//	}

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		CustRequire other = (CustRequire) obj;
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
		//return "CustRequire [id=" + id + ", booking=" + booking + "]";
		return "CustRequire [id=" + id + "]";
	}
    
}
