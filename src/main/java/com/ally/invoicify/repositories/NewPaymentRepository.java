package com.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ally.invoicify.models.NewPayment;

public interface NewPaymentRepository extends JpaRepository<NewPayment, Long> {

}
