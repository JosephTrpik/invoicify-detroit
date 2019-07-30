package com.ally.invoicify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.*;

import com.ally.invoicify.models.NewPayment;

public interface NewPaymentRepository extends JpaRepository<NewPayment, Long> {

    List<NewPayment> findAllByInvoiceId(long invoiceId);

    @Query("select  count(method), method from NewPayment n group by method")
    List<NewPayment> findByMethodType();


}
