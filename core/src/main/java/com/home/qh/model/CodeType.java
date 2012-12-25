package com.home.qh.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class represents the basic "country" object in AppFuse that allows for
 * authentication and user management. It implements Acegi Security's
 * UserDetails interface.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Updated by
 *         Dan Kibler (dan@getrolling.com) Extended to implement Acegi
 *         UserDetails interface by David Carter david@carter.net
 */
@Entity(name = "CodeType")
@Table(name = "CodeType", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
@Searchable
@Audited
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CodeType extends BaseObject implements Serializable {
	private static final long serialVersionUID = 3832626162173359411L;

	private String code; // required
	private String name; // required
	private String description;
	private Set<Code> codes;
	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SearchableId
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Default constructor - creates a new instance with no values set.
	 */
	public CodeType() {
	}

	/**
	 * Create a new instance and set the code, name.
	 * 
	 * @param code
	 *          of code type.
	 * @param name
	 *          of code type.
	 */
	public CodeType(final String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Column(nullable = false, length = 50)
	// @NotNull(groups = {Simple.class})
	@NotEmpty
	@SearchableProperty
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(nullable = false, length = 200)
	@SearchableProperty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = true, length = 500)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.EAGER)
	public Set<Code> getCodes() {
		return codes;
	}

	public void setCodes(Set<Code> codes) {
		this.codes = codes;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CodeType)) {
			return false;
		}

		final CodeType codeType = (CodeType) o;

		return !(code != null ? !code.equals(codeType.getCode()) : codeType.getCode() != null);

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
		ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("id", getId())
		    .append("description", this.description).append("code", this.code).append("name", this.name);
		return sb.toString();
	}

}
