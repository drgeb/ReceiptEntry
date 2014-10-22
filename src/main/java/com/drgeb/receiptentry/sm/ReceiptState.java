package com.drgeb.receiptentry.sm;

public enum ReceiptState {
	CreateState,
	ViewState,
	EditState, 
	DeleteState, 
	ExportState,
	TABLEVIEW
}
//TODO REMOVE STATES CheckingCredit && Shipped that are not part of ReceiptEntry