package com.drgeb.receiptentry.sm;

public enum ReceiptState {
	Created,
	Paid,
	Filled, 
	CheckingCredit, 
	Shipped,
}
//TODO REMOVE STATES CheckingCredit && Shipped that are not part of ReceiptEntry