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

import com.ally.invoicify.models.NewPayment;
import com.ally.invoicify.repositories.NewPaymentRepository;

@RestController
@RequestMapping("/api/new-payment")
public class NewPaymentController {
	
	@Autowired
	NewPaymentRepository newPaymentRepo;
	
	@GetMapping
	public List<NewPayment> getAll(){
		return newPaymentRepo.findAll();
	}
	
	@GetMapping("{id}")
	public NewPayment getOne(@PathVariable long id){
		return newPaymentRepo.findOne(id);
	}
	
	@PostMapping
	public NewPayment create(@RequestBody NewPayment newPayment){
		return newPaymentRepo.save(newPayment);
	}
	
	@PutMapping("{id}")
	public NewPayment update(@RequestBody NewPayment newPayment, @PathVariable long id){
		newPayment.setId(id);
		return newPaymentRepo.save(newPayment);
	}
	
	@DeleteMapping("{id}")
	public NewPayment update(@PathVariable long id){
		NewPayment original = newPaymentRepo.findOne(id);
		newPaymentRepo.delete(original);
		return original;
	}
	
}
