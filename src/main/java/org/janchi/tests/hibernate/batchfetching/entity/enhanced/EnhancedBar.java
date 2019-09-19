package org.janchi.tests.hibernate.batchfetching.entity.enhanced;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.janchi.tests.hibernate.batchfetching.entity.unenhanced.UnenhancedFoo;

@Entity
@Table(name = "bar")
public class EnhancedBar {

	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BAR_PROPERTY")
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public UnenhancedFoo getFoo() {
		return foo;
	}

	public void setFoo(UnenhancedFoo foo) {
		this.foo = foo;
	}

	private Long id;

	private String property;

	private UnenhancedFoo foo;
}
