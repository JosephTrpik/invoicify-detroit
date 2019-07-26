package com.ally.invoicify.models;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


import com.ally.invoicify.models.InvoiceLineItem;

@Entity
public abstract class BillingRecord {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private User createdBy;

	@Column(insertable = false, updatable = false) private String dtype;

	private String dtype2;
	
	private String description;

	@JsonManagedReference(value="thirdParent")
	@OneToMany(mappedBy="billingRecord", cascade=CascadeType.ALL)
	private List<InvoiceLineItem> lineItems;
	
	@ManyToOne
	private Company client;
	
	public BillingRecord() {}
	
	public BillingRecord(String description, Company client, User createdBy, String dtype2) {
		this();
		this.description = description;
		this.client = client;
		this.setCreatedBy(createdBy);
		this.dtype2 = dtype2;
	}
	
	public abstract double getTotal();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public String getDtype(){
		return dtype;
	}

	// public String getDtype2() {
	// 	return dtype2;
	// }

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<InvoiceLineItem> getLineItem() {
		return this.lineItems;
	}

	public void setLineItem(InvoiceLineItem lineItem) {
		this.lineItems.add(lineItem);
	}

	public Company getClient() {
		return client;
	}

	public void setClient(Company client) {
		this.client = client;
	}
	
}
