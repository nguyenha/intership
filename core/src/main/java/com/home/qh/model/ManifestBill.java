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
 * This class represents the basic "manifestBill" object in AppFuse that allows for authentication
 * and user management.  It implements Acegi Security's UserDetails interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *         Updated by Dan Kibler (dan@getrolling.com)
 *         Extended to implement Acegi UserDetails interface
 *         by David Carter david@carter.net
 */
@Entity
@Table(name = "manifestBill")
@Searchable
@Audited

public class ManifestBill extends BaseObject implements Serializable {
    private static final long serialVersionUID = 3832626162173359411L;

    private Long id;
    private Bill bill;                    // required
    private Manifest manifest;                    // required
   
    
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public ManifestBill() {
    }

    /**
     * Create a new instance and set the code, name.
     *
     * @param code of manifestBill.
     * @param name of manifestBill.
     */
    public ManifestBill(final Bill bill, Manifest manifest) {
        this.bill = bill;
        this.manifest = manifest;
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
    @JoinColumn(name="bill_id")
    public Bill getBill() {
		return bill;
	}

    @ManyToOne
    @JoinColumn(name="manifest_id")
	public Manifest getManifest() {
		return manifest;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public void setManifest(Manifest manifest) {
		this.manifest = manifest;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
		result = prime * result + ((manifest == null) ? 0 : manifest.hashCode());		
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
		ManifestBill other = (ManifestBill) obj;
		if (bill == null) {
			if (other.bill != null)
				return false;
		} else if (!bill.equals(other.bill))
			return false;
		if (manifest == null) {
			if (other.manifest != null)
				return false;
		} else if (!manifest.equals(other.manifest))
			return false;
		
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ManifestBill [id=" + id + ", bill=" + bill + ", manifest=" + manifest + "]";
	}
    
}
