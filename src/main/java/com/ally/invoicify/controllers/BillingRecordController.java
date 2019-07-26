package com.ally.invoicify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.ally.invoicify.models.BillingRecord;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/billing-record")
public class BillingRecordController {
	
	private BillingRecordRepository recordRepository;

	public BillingRecordController(BillingRecordRepository recordRepository, CompanyRepository companyRepository) {
		this.recordRepository = recordRepository;
	}

	@GetMapping
	public List<BillingRecord> list() {
		return recordRepository.findAll();
	}

	@GetMapping("{id}")
    public List<BillingRecord> getRecordByCompanyId(@PathVariable Long id){
        return recordRepository.findByClientId(id);
	}
	
	@DeleteMapping("{id}")
	public BillingRecord update(@PathVariable long id){
		BillingRecord original = recordRepository.findOne(id);
		recordRepository.delete(original);
		return original;
	}
	
	
}