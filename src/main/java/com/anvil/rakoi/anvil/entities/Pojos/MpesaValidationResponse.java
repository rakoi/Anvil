package com.anvil.rakoi.anvil.entities.Pojos;

public class MpesaValidationResponse{
	public MpesaValidationResponse() {
	}

	public MpesaValidationResponse(String transactionType, String transId, String transTime, String transAmount, String businessShortCode, String billRefNumber, String invoiceNumber, String orgAccountBalance, String thirdPartyTransId, String msisdn, String firstName, String middleName, String lastName) {
		TransactionType = transactionType;
		TransId = transId;
		TransTime = transTime;
		TransAmount = transAmount;
		BusinessShortCode = businessShortCode;
		BillRefNumber = billRefNumber;
		InvoiceNumber = invoiceNumber;
		OrgAccountBalance = orgAccountBalance;
		ThirdPartyTransId = thirdPartyTransId;
		Msisdn = msisdn;
		FirstName = firstName;
		MiddleName = middleName;
		LastName = lastName;
	}

	public String TransactionType;
	public String TransId;
	public String TransTime;
	public String TransAmount;
	public String BusinessShortCode;
	public String BillRefNumber;
	public String InvoiceNumber;
	public String OrgAccountBalance;
	public String ThirdPartyTransId;
	public String Msisdn;
	public String FirstName;
	public String MiddleName;
	public String LastName;

	public String getTransactionType() {
		return TransactionType;
	}

	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}

	public String getTransId() {
		return TransId;
	}

	public void setTransId(String transId) {
		TransId = transId;
	}

	public String getTransTime() {
		return TransTime;
	}

	public void setTransTime(String transTime) {
		TransTime = transTime;
	}

	public String getTransAmount() {
		return TransAmount;
	}

	public void setTransAmount(String transAmount) {
		TransAmount = transAmount;
	}

	public String getBusinessShortCode() {
		return BusinessShortCode;
	}

	public void setBusinessShortCode(String businessShortCode) {
		BusinessShortCode = businessShortCode;
	}

	public String getBillRefNumber() {
		return BillRefNumber;
	}

	public void setBillRefNumber(String billRefNumber) {
		BillRefNumber = billRefNumber;
	}

	public String getInvoiceNumber() {
		return InvoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		InvoiceNumber = invoiceNumber;
	}

	public String getOrgAccountBalance() {
		return OrgAccountBalance;
	}

	public void setOrgAccountBalance(String orgAccountBalance) {
		OrgAccountBalance = orgAccountBalance;
	}

	public String getThirdPartyTransId() {
		return ThirdPartyTransId;
	}

	public void setThirdPartyTransId(String thirdPartyTransId) {
		ThirdPartyTransId = thirdPartyTransId;
	}

	public String getMsisdn() {
		return Msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.Msisdn = msisdn;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "MpesaValidationResponse{" +
				"TransactionType='" + TransactionType + '\'' +
				", TransId='" + TransId + '\'' +
				", TransTime='" + TransTime + '\'' +
				", TransAmount='" + TransAmount + '\'' +
				", BusinessShortCode='" + BusinessShortCode + '\'' +
				", BillRefNumber='" + BillRefNumber + '\'' +
				", InvoiceNumber='" + InvoiceNumber + '\'' +
				", OrgAccountBalance='" + OrgAccountBalance + '\'' +
				", ThirdPartyTransId='" + ThirdPartyTransId + '\'' +
				", MSISDN='" + Msisdn + '\'' +
				", FirstName='" + FirstName + '\'' +
				", MiddleName='" + MiddleName + '\'' +
				", LastName='" + LastName + '\'' +
				'}';
	}
}