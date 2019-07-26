package com.ally.invoicify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import org.springframework.data.repository.query.*;

import org.springframework.scheduling.annotation.*;

import com.ally.invoicify.models.BillingRecord;

public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {

	List<BillingRecord> findByIdIn(long[] recordIds);

	List<BillingRecord> findByClientId(Long clientId);

	// @Async
	// @Query("SELECT dtype FROM BillingRecord where id = :id") 
    // BillingRecord findTest(@Param("id") Long id);

	// BillingRecord findBy

//	List<BillingRecord> findByClientIdAndLineItemIsNull(long clientId);

}
