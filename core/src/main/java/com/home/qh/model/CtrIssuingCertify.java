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

/**
 * This class represents the basic "ctrIssuingCertify" object in AppFuse that allows for authentication
 * and user management.  It implements Acegi Security's UserDetails interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *         Updated by Dan Kibler (dan@getrolling.com)
 *         Extended to implement Acegi UserDetails interface
 *         by David Carter david@carter.net
 */
@Entity
@Table(name = "ctrIssuingCertify")
@Searchable
@Audited

public class CtrIssuingCertify extends BaseObject implements Serializable {
    private static final long serialVersionUID = 3832626162173359411L;

    private Long id;
    private String sealNo;                       		
    private String description;                    
   
    private Booking booking;
    private Equipment equipment;
    private CtrKindPackage ctrKindPackage;
    
    
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public CtrIssuingCertify() {
    }

    /**
     * Create a new instance and set the code, name.
     *
     * @param code of ctrIssuingCertify.
     * @param name of ctrIssuingCertify.
     */
    public CtrIssuingCertify(final Booking booking) {
        this.booking = booking;
       
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
  
    @ManyToOne
    @JoinColumn(name="booking_id")
	public Booking getBooking() {
		return booking;
	}

	public String getDescription() {
		return description;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSealNo() {
		return sealNo;
	}


    @JoinColumn(name="equipment_id")
	public Equipment getEquipment() {
		return equipment;
	}
    
    @JoinColumn(name="ctrKindPackage_id")
	public CtrKindPackage getCtrKindPackage() {
		return ctrKindPackage;
	}

	public void setCtrKindPackage(CtrKindPackage ctrKindPackage) {
		this.ctrKindPackage = ctrKindPackage;
	}

	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
				
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
		CtrIssuingCertify other = (CtrIssuingCertify) obj;
		if (booking == null) {
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
				
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CtrIssuingCertify [id=" + id + ", booking=" + booking + "]";
	}
    
}
