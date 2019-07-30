package com.ally.invoicify.models;

import java.util.List;



public class Data {

    private double avergeInvoiceAmount;

    private List<Invoice> averageCurrentBalanceByCompany;
    
    private List<Invoice> findAverageTimeToPay;

    private List<Invoice> findSumInitalBalance;

    private List<Invoice> findTotalOutstandingAmount;

    private List<Invoice> findTotalOutstandingInvoices;

    private List<Invoice> findTotalPaidInvoices;
    
    private List<BillingRecord> findByRecordType;

    private List<NewPayment> findByMethodType;
	
}
