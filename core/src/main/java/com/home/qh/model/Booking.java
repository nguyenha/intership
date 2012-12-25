package com.home.qh.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.hibernate.envers.Audited;

/**
 * This class represents the basic "Booking" object in AppFuse that allows for authentication
 * and user management.  It implements Acegi Security's UserDetails interface.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *         Updated by Dan Kibler (dan@getrolling.com)
 *         Extended to implement Acegi UserDetails interface
 *         by David Carter david@carter.net
 */
@Entity
@Table(name = "booking")
@Searchable
@Audited
public class Booking extends BaseObject implements Serializable {
    private static final long serialVersionUID = 3832626162173359411L;
    public final static String BOOKING_STATUS_CREATED="Created";
    
    private Long id;
    private String transporterCode;                    // required 
    private String description;
    private Date bookingDate;							//required
    private Date issueDate;
    private Integer bookingNo; 							// required
    private String shipingMarks;    
    private String goodsDescription;
    private String saleOrder;
    private String custOrder;
    private String billPaperNumber;
    private String imageMarks;
    private String bookingStatus;
    private String placeAcptCode;
    private String placeAcptCodeType;    
    private String placeDeliveryCode;
    private String placeDeliveryCodeType;
    private String placeFreightCode;
    private String placeFreightCodeType;    
    private String finalDestCode;
    private String finalDestCodeType;
    private Date ctrIssueDate;
    private String ctrRecvPerson;
    private String packagePlaceCode;
    private String packagePlaceType;
    private String billFreightType;
           
    private Paying paying;							// 
    private Voyage voyage;
    private Customer shipper;
    private Customer consignee;
    private Partner partner;
    private Nos deliveryNos;
    private Nos destinationNos;
    private GoodsStatus goodsStatus;   
    private Store ctrStore;   
    private Port portLoading;
    private Port portDischarge;
    
    private TransCtrType transCtrType;    
    
    private Set<TransParty> transParties;				
    private Set<TransFreight> transFreights;				 
    private Set<TransGoodsDesc> transGoodsDescs;		
    private Set<AdditionalClause> AdditionalClauses;
    private Set<Bill> bill;
    private Set<CtrIssuingCertify> ctrIssuingCertify;
    private Set<ShippingInstr> shippingInstr;
    
    
    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Booking() {
    }

    /**
     * Create a new instance and set the code, name.
     *
     * @param bookingDate of booking.
     * @param bookingNo of booking.
     */
    public Booking(final Date bookingDate, int bookingNo) {
    	this.bookingNo = bookingNo;
        this.bookingDate = bookingDate;
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

	public String getTransporterCode() {
		return transporterCode;
	}

	

	public Date getBookingDate() {
		return bookingDate;
	}

	public Integer getBookingNo() {
		return bookingNo;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public String getShipingMarks() {
		return shipingMarks;
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

	@Column(nullable = true, length = 500)
    public String getDescription() {
		return description;
	}
	
	@ManyToOne
    @JoinColumn(name="paying_id")	
	public Paying getPaying() {
		return paying;
	}
		
	@ManyToOne
    @JoinColumn(name="voyage_id")
  	public Voyage getVoyage() {
		return voyage;
	}

	
	public String getPlaceAcptCode() {
		return placeAcptCode;
	}

	
	public String getPlaceDeliveryCode() {
		return placeDeliveryCode;
	}

	@ManyToOne
    @JoinColumn(name="shipper_id")
	public Customer getShipper() {
		return shipper;
	}

	@ManyToOne
    @JoinColumn(name="consignee_id")
	public Customer getConsignee() {
		return consignee;
	}

	@ManyToOne
    @JoinColumn(name="partner_id")
	public Partner getPartner() {
		return partner;
	}

	@ManyToOne
    @JoinColumn(name="deliveryNos_id")
	public Nos getDeliveryNos() {
		return deliveryNos;
	}
	
	@ManyToOne
    @JoinColumn(name="destinationNos_id")
	public Nos getDestinationNos() {
		return destinationNos;
	}

	public void setDestinationNos(Nos destinationNos) {
		this.destinationNos = destinationNos;
	}

	@ManyToOne
    @JoinColumn(name="goodsStatus_id")
	public GoodsStatus getGoodsStatus() {
		return goodsStatus;
	}


	public String getPlaceFreightCode() {
		return placeFreightCode;
	}

	@ManyToOne
    @JoinColumn(name="transCtrType_id")
	public TransCtrType getTransCtrType() {
		return transCtrType;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<TransParty> getTransParties() {
		return transParties;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<TransFreight> getTransFreights() {
		return transFreights;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<TransGoodsDesc> getTransGoodsDescs() {
		return transGoodsDescs;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<AdditionalClause> getAdditionalClauses() {
		return AdditionalClauses;
	}
	
	
	public String getPlaceAcptCodeType() {
		return placeAcptCodeType;
	}

	public String getPlaceDeliveryCodeType() {
		return placeDeliveryCodeType;
	}

	public String getPlaceFreightCodeType() {
		return placeFreightCodeType;
	}

	public String getFinalDestCode() {
		return finalDestCode;
	}

	public String getFinalDestCodeType() {
		return finalDestCodeType;
	}

	@ManyToOne
    @JoinColumn(name="portLoading_id")
	public Port getPortLoading() {
		return portLoading;
	}

	@ManyToOne
    @JoinColumn(name="portDischarge_id")
	public Port getPortDischarge() {
		return portDischarge;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	public Set<ShippingInstr> getShippingInstr() {
		return shippingInstr;
	}
		
	public Date getCtrIssueDate() {
		return ctrIssueDate;
	}

	public String getCtrRecvPerson() {
		return ctrRecvPerson;
	}

	public String getPackagePlaceCode() {
		return packagePlaceCode;
	}

	public String getPackagePlaceType() {
		return packagePlaceType;
	}

	public void setPackagePlaceCode(String packagePlaceCode) {
		this.packagePlaceCode = packagePlaceCode;
	}

	public void setPackagePlaceType(String packagePlaceType) {
		this.packagePlaceType = packagePlaceType;
	}

	@ManyToOne
    @JoinColumn(name="ctrStore_id")
	public Store getCtrStore() {
		return ctrStore;
	}

	public void setCtrIssueDate(Date ctrIssueDate) {
		this.ctrIssueDate = ctrIssueDate;
	}

	public void setCtrRecvPerson(String ctrRecvPerson) {
		this.ctrRecvPerson = ctrRecvPerson;
	}

	public void setCtrStore(Store ctrStore) {
		this.ctrStore = ctrStore;
	}

	public void setShippingInstr(Set<ShippingInstr> shippingInstr) {
		this.shippingInstr = shippingInstr;
	}

	public void setPlaceAcptCodeType(String placeAcptCodeType) {
		this.placeAcptCodeType = placeAcptCodeType;
	}

	public void setPlaceDeliveryCodeType(String placeDeliveryCodeType) {
		this.placeDeliveryCodeType = placeDeliveryCodeType;
	}

	public void setPlaceFreightCodeType(String placeFreightCodeType) {
		this.placeFreightCodeType = placeFreightCodeType;
	}

	public void setFinalDestCode(String finalDestCode) {
		this.finalDestCode = finalDestCode;
	}

	public void setFinalDestCodeType(String finalDestCodeType) {
		this.finalDestCodeType = finalDestCodeType;
	}

	public void setPortLoading(Port portLoading) {
		this.portLoading = portLoading;
	}

	public void setPortDischarge(Port portDischarge) {
		this.portDischarge = portDischarge;
	}

//	@OneToMany(fetch = FetchType.EAGER)
	@OneToMany(fetch = FetchType.LAZY)
	public Set<Bill> getBill() {
		return bill;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	public Set<CtrIssuingCertify> getCtrIssuingCertify() {
		return ctrIssuingCertify;
	}

	@Column(nullable = true, length = 3)	
	public String getBookingStatus() {
		return bookingStatus;
	}
	
	public String getImageMarks() {
		return imageMarks;
	}
		
	public String getBillFreightType() {
		return billFreightType;
	}

	public void setBillFreightType(String billFreightType) {
		this.billFreightType = billFreightType;
	}

	public void setImageMarks(String imageMarks) {
		this.imageMarks = imageMarks;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public void setCtrIssuingCertify(Set<CtrIssuingCertify> ctrIssuingCertify) {
		this.ctrIssuingCertify = ctrIssuingCertify;
	}

	public void setBill(Set<Bill> bill) {
		this.bill = bill;
	}

	public void setTransporterCode(String transporterCode) {
		this.transporterCode = transporterCode;
	}

//	public String getContainerType() {
//		return containerType;
//	}
//	
//	public void setContainerType(String containerType) {
//		this.containerType = containerType;
//	}

	public void setPaying(Paying paying) {
		this.paying = paying;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	public void setDescription(Long id) {
		this.id = id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public void setPlaceAcptCode(String placeAcptCode) {
		this.placeAcptCode = placeAcptCode;
	}

	public void setPlaceDeliveryCode(String placeDeliveryCode) {
		this.placeDeliveryCode = placeDeliveryCode;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public void setShipingMarks(String shipingMarks) {
		this.shipingMarks = shipingMarks;
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

	public void setShipper(Customer shipper) {
		this.shipper = shipper;
	}

	public void setConsignee(Customer consignee) {
		this.consignee = consignee;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public void setDeliveryNos(Nos deliveryNos) {
		this.deliveryNos = deliveryNos;
	}

	public void setGoodsStatus(GoodsStatus goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public void setPlaceFreightCode(String placeFreightCode) {
		this.placeFreightCode = placeFreightCode;
	}

	public void setTransCtrType(TransCtrType transCtrType) {
		this.transCtrType = transCtrType;
	}

	public void setTransParties(Set<TransParty> transParties) {
		transParties = transParties;
	}

	public void setTransFreights(Set<TransFreight> transFreights) {
		this.transFreights = transFreights;
	}

	public void setTransGoodsDescs(Set<TransGoodsDesc> transGoodsDescs) {
		this.transGoodsDescs = transGoodsDescs;
	}

	public void setAdditionalClauses(Set<AdditionalClause> additionalClauses) {
		AdditionalClauses = additionalClauses;
	}

	public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof Booking)) {
//            return false;
//        }
//
//        final Booking booking = (Booking) o;
//
//        return !(bookingDate != null ? !bookingDate.equals(booking.getBookingDate()) : booking.getBookingDate() != null);
		return true;
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
    	
       // return (bookingDate != null ? bookingDate.hashCode() : 0);
    	
    	return 0;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
//        ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
//                .append("bookingDate", this.bookingDate)
//                .append("No", this.bookingNo);        
//        return sb.toString();
    	return null;
    }
    
}
