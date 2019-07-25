package com.ally.invoicify.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.models.InvoiceLineItem;
import com.ally.invoicify.models.InvoiceView;
import com.ally.invoicify.models.User;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.repositories.CompanyRepository;
import com.ally.invoicify.repositories.InvoiceRepository;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
	
	@Autowired
	private BillingRecordRepository recordRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@PostMapping("{clientId}")
	public Invoice createInvoice(@RequestBody InvoiceView invoiceView, @PathVariable long clientId, Authentication auth) {
		User creator = (User) auth.getPrincipal();
		List<BillingRecord> records = recordRepository.findByIdIn(invoiceView.getRecordIds());
		long nowish = Calendar.getInstance().getTimeInMillis();
		Date now = new Date(nowish);
		Invoice invoice = new Invoice();
		invoice.setInvoiceDescription(invoiceView.getInvoiceDescription());
		double total = 0;
		
		List<InvoiceLineItem> items = new ArrayList<InvoiceLineItem>();
		for (BillingRecord record : records) {
			InvoiceLineItem lineItem = new InvoiceLineItem();
			lineItem.setBillingRecord(record);
			lineItem.setCreatedBy(creator);
			lineItem.setCreatedOn(now);
			lineItem.setInvoice(invoice);
			items.add(lineItem);
			total += record.getTotal();
		}
		
		invoice.setLineItems(items);
		invoice.setCreatedBy(creator);
		invoice.setCreatedOn(now);
		invoice.setCompany(companyRepository.findOne(clientId));
		invoice.setPaidOn(null);
		invoice.setBalance(total);
		
		return invoiceRepository.save(invoice);
	}
	@GetMapping("/company/{companyId}")
	public List<Invoice> list(@PathVariable long companyId) {
		System.out.println("COMPANY ID -->"+companyId);
		return invoiceRepository.findByCompanyId(companyId);
	}	

	@GetMapping
	public List<Invoice> list() {
		return invoiceRepository.findAll();
	}

	@GetMapping("{id}")
	public Invoice getOne(@PathVariable Long id) {
		return invoiceRepository.findOne(id);
	}
	
}


















