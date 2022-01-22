package com.anvil.rakoi.anvil;

import com.anvil.rakoi.anvil.entities.mpesatransactions;
import com.anvil.rakoi.anvil.repos.MpesaTransactionsRepository;
import com.anvil.rakoi.anvil.repos.ParcelPagingAndSortingRepository;
import com.anvil.rakoi.anvil.repos.ParcelRepository;
import com.anvil.rakoi.anvil.repos.TripRepository;
import com.anvil.rakoi.anvil.services.InvoiceServiceInterfaceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnvilApplicationTests {

	@Autowired
	TripRepository tripRepository;

	@Autowired
	MpesaTransactionsRepository mpesaTransactionsRepository;

	@Autowired
	ParcelPagingAndSortingRepository parcelPagingAndSortingRepository;
	@Autowired
	ParcelRepository parcelRepository;
	@Autowired
	InvoiceServiceInterfaceImpl invoiceService;

	@Test
	void getParcel(){
		System.out.println(parcelPagingAndSortingRepository.findById(23));
	}

	@Test
	void testSaveMpesaTransaction(){
		mpesatransactions transaction=new mpesatransactions();
		transaction.setAmount(12.0);
		transaction.setMerchantRequestID("test");
		transaction.setMpesaReceiptNumber("testrec");
		transaction.setPhoneNumber("0702164611");

		mpesaTransactionsRepository.save(transaction);
	}

	@Test
	void testGetUser() {
		System.out.println("Test");
	}

	@Test
	void generateInvoices() {
		invoiceService.generateInvoices();

	}









}
