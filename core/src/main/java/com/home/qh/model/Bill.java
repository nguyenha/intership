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
 * This class represents the basic "country" object in AppFuse that allows for authentication
 * and user management.  It implements Acegi Security's UserDetails interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *         Updated by Dan Kibler (dan@getrolling.com)
 *         Extended to implement Acegi UserDetails interface
 *         by David Carter david@carter.net
 */
@Entity
@Table(name = "bill")
@Searchable
@Audited

public class Bill extends BaseObject implements Serializable {
    private static final long serialVersionUID = 3832626162173359411L;

    private Long id; 
    private String billNo; 							// required, unique
    private String shipper;                    		
    private String consignee;                    
    private String party;
    private String vessel;	    
    private String voyage; 							
    private String portLoading;                    		
    private String portDischarge;                   
    private String placeAcceptance;
    private String placeDilivery;    
    private String placeFreight;
    private String finalDestination;
    private String nos;
    private String paying;
    private String shipingMarks;
    private String imageMarks;
    private String goodsDescription;
    private String saleOrder;
    private String custOrder;
    private String billPaperNumber;
    private String partner;   
    private String goodsStatus;
    private String issueDate;
    private String AdditionalClauses;
    private String description;
    
    private Booking booking;
    
    private Set<BillGoods> billGoods;				
    private Set<BillFreight> billFreight;
    private Set<ManifestBill> manifestBill;
      
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Bill() {
    }

    /**
     * Create a new instance and set the code, name.
     *
     * @param billDate of bill.
     * @param billNo of bill.
     */
    public Bill(final String billDate, int billNo) {
//        this.billNo = billNo;
//        this.billDate = billDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
        return id;
    }

    @Column(nullable = false, length = 40, unique = true)
    @SearchableProperty
	public String getBillNo() {
		return billNo;
	}

	public String getShipper() {
		return shipper;
	}

	public String getConsignee() {
		return consignee;
	}

	public String getParty() {
		return party;
	}

	public String getVessel() {
		return vessel;
	}

	public String getVoyage() {
		return voyage;
	}

	public String getPortLoading() {
		return portLoading;
	}

	public String getPortDischarge() {
		return portDischarge;
	}

	public String getPlaceAcceptance() {
		return placeAcceptance;
	}

	public String getPlaceDilivery() {
		return placeDilivery;
	}

	public String getPlaceFreight() {
		return placeFreight;
	}

	public String getFinalDestination() {
		return finalDestination;
	}

	public String getNos() {
		return nos;
	}

	public String getPaying() {
		return paying;
	}

	public String getShipingMarks() {
		return shipingMarks;
	}

	public String getImageMarks() {
		return imageMarks;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public String getSaleOrder() {
		return saleOrder;
	}

	public String getCustOrder() {
		return custOrder;
	}

	public String getBillPaperNumber() {
		return billPaperNumber;
	}

	public String getPartner() {
		return partner;
	}

	public String getGoodsStatus() {
		return goodsStatus;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public String getAdditionalClauses() {
		return AdditionalClauses;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public void setVessel(String vessel) {
		this.vessel = vessel;
	}

	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}

	public void setPortLoading(String portLoading) {
		this.portLoading = portLoading;
	}

	public void setPortDischarge(String portDischarge) {
		this.portDischarge = portDischarge;
	}

	public void setPlaceAcceptance(String placeAcceptance) {
		this.placeAcceptance = placeAcceptance;
	}

	public void setPlaceDilivery(String placeDilivery) {
		this.placeDilivery = placeDilivery;
	}

	public void setPlaceFreight(String placeFreight) {
		this.placeFreight = placeFreight;
	}

	public void setFinalDestination(String finalDestination) {
		this.finalDestination = finalDestination;
	}

	public void setNos(String nos) {
		this.nos = nos;
	}

	public void setPaying(String paying) {
		this.paying = paying;
	}

	public void setShipingMarks(String shipingMarks) {
		this.shipingMarks = shipingMarks;
	}

	public void setImageMarks(String imageMarks) {
		this.imageMarks = imageMarks;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public void setSaleOrder(String saleOrder) {
		this.saleOrder = saleOrder;
	}

	public void setCustOrder(String custOrder) {
		this.custOrder = custOrder;
	}

	public void setBillPaperNumber(String billPaperNumber) {
		this.billPaperNumber = billPaperNumber;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public void setAdditionalClauses(String additionalClauses) {
		AdditionalClauses = additionalClauses;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.EAGER)	
	public Set<BillGoods> getBillGoods() {
		return billGoods;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<BillFreight> getBillFreight() {
		return billFreight;
	}
	
	@ManyToOne
    @JoinColumn(name="booking_id")
	public Booking getBooking() {
		return booking;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<ManifestBill> getManifestBill() {
		return manifestBill;
	}
	
	public void setManifestBill(Set<ManifestBill> manifestBill) {
		this.manifestBill = manifestBill;
	}
	
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void setBillGoods(Set<BillGoods> billGoods) {
		this.billGoods = billGoods;
	}

	public void setBillFreight(Set<BillFreight> billFreight) {
		this.billFreight = billFreight;
	}

	public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bill)) {
            return false;
        }

        final Bill bill = (Bill) o;

        return !(bill != null ? !bill.equals(bill.getBillNo()) : bill.getBillNo() != null);

    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (billNo != null ? billNo.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
                .append("billNo", this.billNo);                     
        return sb.toString();
    }
    
}
