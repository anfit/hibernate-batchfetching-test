package org.janchi.tests.hibernate.batchfetching.entity.unenhanced;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.janchi.tests.hibernate.batchfetching.entity.enhanced.EnhancedBar;

@Entity
@Table(name = "foo")
public class UnenhancedFoo {

	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FOO_PROPERTY")
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public EnhancedBar getBar() {
		return bar;
	}

	public void setBar(EnhancedBar bar) {
		this.bar = bar;
	}

	private Long id;

	private String property;

	private EnhancedBar bar;
}
