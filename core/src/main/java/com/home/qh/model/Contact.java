package com.home.qh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;

@Embeddable
@Searchable(root = false)
public class Contact extends BaseObject implements Serializable {
    private static final Log log = LogFactory.getLog(Address.class);
    private static final long serialVersionUID = 3617859655330969141L;
	
	private String name;
	private String phone;
	private String fax;
	private String email;
	private String website;

	@Column(length = 200)
	@SearchableProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20)
	@SearchableProperty
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 20)
	@SearchableProperty
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(length = 50)
	@SearchableProperty
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20)
	@SearchableProperty
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("name", this.name)
        .append("phone", this.phone)
        .append("fax", this.fax)
        .append("email", this.email)
        .append("website", this.website).toString();
	}

	@Override
	public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contact)) {
            return false;
        }

        final Contact contact1 = (Contact) o;

        return this.hashCode() == contact1.hashCode();
	}

	@Override
	public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);
        result = 29 * result + (phone != null ? phone.hashCode() : 0);
        result = 29 * result + (fax != null ? fax.hashCode() : 0);
        result = 29 * result + (email != null ? email.hashCode() : 0);
        result = 29 * result + (website != null ? website.hashCode() : 0);
        return result;
	}

}
