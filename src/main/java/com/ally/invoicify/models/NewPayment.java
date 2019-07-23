package com.ally.invoicify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class NewPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long amount;

	private String method;

	@ManyToOne
	private Company company;

	@ManyToOne
	private Invoice invoice;

	public NewPayment() {
	}

	public NewPayment(Long amount, String method, Company company, Invoice invoice) {
		this();
		this.amount = amount;
		this.method = method;
		this.company = company;
		this.invoice = invoice;
	}

	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

}
