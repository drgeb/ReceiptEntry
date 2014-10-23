package com.drgeb.receiptentry.sm;
/**
*
* @author Dr. Gerald E. Bennett
* Following architectural pattern of Jason Zhicheng Li (jason@lizjason.com)
*/
public enum ReceiptState {
	CreateState,
	ViewState,
	EditState, 
	DeleteState, 
	ExportState,
	TABLEVIEW
}
//TODO REMOVE STATES CheckingCredit && Shipped that are not part of ReceiptEntry