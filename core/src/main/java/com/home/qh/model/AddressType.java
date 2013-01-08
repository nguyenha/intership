package com.home.qh.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

@Embeddable
@Searchable(root = false)
public class AddressType extends BaseObject implements Serializable {
	private Long id;
	private String code;
	private String name;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SearchableId
    public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
		this.id = id;
	}
	
    @Column(length=20)
    @SearchableProperty
	public String getCode() {
		return code;
	}

    @Column(length=50)
    @SearchableProperty
	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE);
        sb.append("{code = ").append((code != null) ? code : "").append('\n');
        sb.append("name = ").append((name != null) ? name : "");
        sb.append('}');
        return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressType that = (AddressType) o;

        if (code != null ? !code.equals(that.getCode()) : that.getCode() != null) return false;
        if (name != null ? !name.equals(that.getName()) : that.getName() != null) return false;

        return true;
	}

	@Override
	public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
	}

}
