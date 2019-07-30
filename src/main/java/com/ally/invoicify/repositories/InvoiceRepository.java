package com.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ally.invoicify.models.Invoice;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByCompanyId(Long companyId);

    List<Invoice> findByPaidOnNotNull();

    List<Invoice> findByPaidOnNull();
    
    @Query("select avg(initialBalance) from Invoice i")
    double findAverageInvoiceAmount();

    @Query("select avg(currentBalance), company.id from Invoice i group by company")
    List<Invoice> findAverageCurrentBalanceByCompany();


    @Query("select paidOn - createdOn, invoiceDescription from Invoice i where paidOn != null")
    List<Invoice> findAverageTimeToPay();

    @Query("select sum(initialBalance) from Invoice i")
    List<Invoice> findSumInitalBalance();


    @Query("select sum(abs(currentBalance-initialBalance)) from Invoice i")
    List<Invoice> findTotalOutstandingAmount();

    @Query("select count(id) from Invoice i WHERE currentBalance > 0")
    List<Invoice> findTotalOutstandingInvoices();

    @Query("select count(id) from Invoice i WHERE currentBalance <= 0")
    List<Invoice> findTotalPaidInvoices();

    

    

    

    

    
    


    
}
