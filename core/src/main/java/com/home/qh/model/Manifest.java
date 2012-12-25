package com.home.qh.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.hibernate.envers.Audited;


@Entity
@Table(name="manifest")
@Searchable
@Audited

public class Manifest extends BaseObject implements Serializable{
 private static final long serialVersionUID = 3832626162173359411L;
	  
	private Long id;
	private Voyage voyage;						
	private Port port;
	
	private Set<ManifestBill> manifestBill;
			
	public Manifest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manifest(final Voyage voyage, Port port) {
		super();
		this.voyage = voyage;
		this.port = port;				
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
	
	@ManyToOne
    @JoinColumn(name="voyage_id")
	public Voyage getVoyage() {
		return voyage;
	}
	
	@ManyToOne
    @JoinColumn(name="port_id")
	public Port getPort() {
		return port;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<ManifestBill> getManifestBill() {
		return manifestBill;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	public void setManifestBill(Set<ManifestBill> manifestBill) {
		this.manifestBill = manifestBill;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((voyage == null) ? 0 : voyage.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());		
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
		Manifest other = (Manifest) obj;
		if (voyage == null) {
			if (other.voyage != null)
				return false;
		} else if (!voyage.equals(other.voyage))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manifest [id=" + id + ", voyage=" + voyage + ", port=" + port + "]";
	}
}