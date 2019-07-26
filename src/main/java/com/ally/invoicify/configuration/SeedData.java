package com.ally.invoicify.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ally.invoicify.models.Company;
import com.ally.invoicify.models.FlatFeeBillingRecord;
import com.ally.invoicify.models.RateBasedBillingRecord;
import com.ally.invoicify.models.User;
import com.ally.invoicify.models.InvoiceView;
import com.ally.invoicify.repositories.BillingRecordRepository;
import com.ally.invoicify.repositories.CompanyRepository;
import com.ally.invoicify.repositories.InvoiceLineItemRepository;
import com.ally.invoicify.repositories.InvoiceRepository;
import com.ally.invoicify.repositories.UserRepository;
import com.ally.invoicify.models.*;
import java.util.*;
import java.sql.Date;
@Configuration
public class SeedData {
    public SeedData(BillingRecordRepository recordRepository, CompanyRepository companyRepository,
            UserRepository userRepository, InvoiceLineItemRepository invoiceLineItemRepository , InvoiceRepository invoiceRepository , PasswordEncoder encoder) {
        User admin = userRepository.save(new User("admin", encoder.encode("admin")));
        Company ajax = companyRepository.save(new Company("AJAX Ltd."));
        Company lomax = companyRepository.save(new Company("Lomax Brothers, LLC"));
        recordRepository.save(new FlatFeeBillingRecord(300, "Faxes", ajax, admin));
        BillingRecord billingRecord = recordRepository.save(new FlatFeeBillingRecord(1.75, "Socks", ajax, admin));
        recordRepository.save(new FlatFeeBillingRecord(500, "Paper", lomax, admin));
        recordRepository.save(new FlatFeeBillingRecord(72.33, "Stockings", lomax, admin));
        recordRepository.save(new FlatFeeBillingRecord(142.99, "Paint", lomax, admin));
        recordRepository.save(new RateBasedBillingRecord(500, 3.5, "Legal services", ajax, admin));
        recordRepository.save(new RateBasedBillingRecord(150, 2.5, "Painting", ajax, admin));
        recordRepository.save(new RateBasedBillingRecord(100, 4.25, "House cleaning", ajax, admin));
        recordRepository.save(new RateBasedBillingRecord(700, 8, "Palm reading", lomax, admin));
        recordRepository.save(new RateBasedBillingRecord(1.57, 25, "Show shining", lomax, admin));
		
		// long[] arrays = new long[]{13};
        // InvoiceView view = new InvoiceView("Test!@#",arrays);
        // invoiceRepository.save(view,ajax.getId());
        Invoice invoice = invoiceRepository.save(new Invoice());
        
        invoice.setCreatedBy(admin);
        invoice.setInvoiceDescription("TEST!@#");
        
        InvoiceLineItem lineItem = new InvoiceLineItem();
        List<InvoiceLineItem> lineItems = new ArrayList<>();
        long nowish = Calendar.getInstance().getTimeInMillis();
        Date now = new Date(nowish);
        lineItem.setBillingRecord(billingRecord);
        lineItem.setCreatedBy(admin);
        lineItem.setCreatedOn(now);
        lineItem.setInvoice(invoice);
        InvoiceLineItem temp = invoiceLineItemRepository.save(lineItem);
        lineItems.add(temp);
        invoice.setLineItems(lineItems);
        invoice.setCompany(ajax);
        invoice.setCreatedOn(now);
        invoice.setCurrentBalance(1.75);
        invoice.setInitialBalance(1.75);
        invoiceRepository.save(invoice);
    }
}