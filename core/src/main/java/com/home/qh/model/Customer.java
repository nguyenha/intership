package com.home.qh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Table(name = "customer")
@Searchable
@Audited
public class Customer extends BaseObject implements Serializable {
	private static final long serialVersionUID = 3832626162173359411L;

    private Long id;
    private String fullName;
    private String description;
    private Date joinDate;
    private Double balance;
    
    private Contact contact;
//    private PurchaseInfo purchaseInfo;
    
    private Set<Address> addresses;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Column(nullable = false, length = 200)
    @SearchableProperty
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

    @Column(nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    @Column(nullable = true)
	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	@OneToMany(fetch = FetchType.EAGER)   
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Embedded
	public Contact getContact() {
		return contact;
	}

	@Column
	public Double getBalance() {
		return balance;
	}

//	@Embedded
//	public PurchaseInfo getPurchaseInfo() {
//		return purchaseInfo;
//	}
//
//	public void setPurchaseInfo(PurchaseInfo purchaseInfo) {
//		this.purchaseInfo = purchaseInfo;
//	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }

        final Customer cus = (Customer) o;

        return !(cus != null ? !cus.equals(cus.getFullName()) : cus.getFullName() != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (id != null ? id.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("fullname", this.fullName)
                .append("description", this.description)
                .append("joinDate", this.joinDate);
        return sb.toString();
    }
    
}
