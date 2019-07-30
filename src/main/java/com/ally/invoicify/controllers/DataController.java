package com.ally.invoicify.controllers;

import java.util.List;
import java.sql.Date;
import java.util.Calendar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ally.invoicify.exceptions.UnknownException;

import com.ally.invoicify.models.Data;
import com.ally.invoicify.repositories.NewPaymentRepository;
import com.ally.invoicify.repositories.InvoiceRepository;
import com.ally.invoicify.repositories.BillingRecordRepository;

@RestController
@RequestMapping("/api/data")
public class DataController {
	
	@Autowired
	NewPaymentRepository newPaymentRepository;
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	BillingRecordRepository recordRepository;

	private Data data = new Data();
	
	@GetMapping
	public Data getData(){
		data.setAvergeInvoiceAmount(invoiceRepository.findAverageInvoiceAmount());
		data.setAverageCurrentBalanceByCompany(invoiceRepository.findAverageCurrentBalanceByCompany());
		data.setFindAverageTimeToPay(invoiceRepository.findAverageTimeToPay());
		data.setFindSumInitalBalance(invoiceRepository.findSumInitalBalance());
		data.setFindTotalOutstandingAmount(invoiceRepository.findTotalOutstandingAmount());
		data.setFindTotalOutstandingInvoices(invoiceRepository.findTotalOutstandingInvoices());
		data.setFindTotalPaidInvoices(invoiceRepository.findTotalPaidInvoices());
		data.setFindByRecordType(recordRepository.findByRecordType());
		data.setFindByMethodType(newPaymentRepository.findByMethodType());

		return data;
	}

}
