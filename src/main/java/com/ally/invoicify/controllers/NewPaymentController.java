package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.auth.In;

import com.ally.invoicify.models.Invoice;
import com.ally.invoicify.models.NewPayment;
import com.ally.invoicify.repositories.NewPaymentRepository;
import com.ally.invoicify.repositories.InvoiceRepository;;

@RestController
@RequestMapping("/api/new-payment")
public class NewPaymentController {
	
	@Autowired
	NewPaymentRepository newPaymentRepo;
	@Autowired
	InvoiceRepository invoiceRepo;
	
	@GetMapping
	public List<NewPayment> getAll(){
		return newPaymentRepo.findAll();
	}
	
	@GetMapping("{id}")
	public NewPayment getOne(@PathVariable long id){
		return newPaymentRepo.findOne(id);
	}
	
	@PostMapping("{invoiceId}")
	public NewPayment create(@RequestBody NewPayment newPayment,  @PathVariable long invoiceId){
		Invoice invoice = invoiceRepo.getOne(invoiceId);

		// invoice.setBalance(invoice.getBalance()- newPayment.getAmount());
		newPayment.setInvoice(invoice);

		return newPaymentRepo.save(newPayment);
	}


	
}
