package com.home.qh.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.hibernate.envers.Audited;

/**
 * This class represents the basic "port" object in AppFuse that allows for authentication
 * and user management.  It implements Acegi Security's UserDetails interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *         Updated by Dan Kibler (dan@getrolling.com)
 *         Extended to implement Acegi UserDetails interface
 *         by David Carter david@carter.net
 */
@Entity
@Table(name = "port")
@Searchable
@Audited
public class Port extends BaseObject implements Serializable {
    private static final long serialVersionUID = 3832626162173359411L;

    private Long id;
    private String code;                    // required
    private String name;                    // required
    private String description;
    private City city;
    private Set<Itinerary> itineraries;
    
    private Set<Booking> bookings;
     
    
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Port() {
    }

    /**
     * Create a new instance and set the code, name.
     *
     * @param code of country.
     * @param name of country.
     */
    public Port(final String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
        return id;
    }

    @Column(nullable = false, length = 50, unique = true)
    @SearchableProperty
    public String getName() {
        return name;
    }

    @Column(nullable = false, length = 50, unique = true)
    @SearchableProperty
    public String getCode() {
        return code;
    }

    @Column(nullable = true, length = 500)
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    @ManyToOne
    @JoinColumn(name="city_id")
	public City getCity() {
		return city;
	}
    
    @OneToMany(fetch = FetchType.EAGER)
	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch = FetchType.EAGER)	
	public Set<Itinerary> getItineraries() {
		return itineraries;
	}

	
	public void setItineraries(Set<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Country)) {
            return false;
        }

        final Country country = (Country) o;

        return !(code != null ? !code.equals(country.getCode()) : country.getCode() != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (code != null ? code.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("code", this.code)
                .append("name", this.name);        
        return sb.toString();
    }
    
}
