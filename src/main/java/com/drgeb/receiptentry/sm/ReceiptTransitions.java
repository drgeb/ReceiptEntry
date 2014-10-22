package com.drgeb.receiptentry.sm;

public interface ReceiptTransitions {
	
	public void createTransaction();
    
	public void viewTransaction();
    
	public void editTransaction();
    
	public void deleteTransaction();
    
	public void exportTransaction();
    
	public void saveReceiptTRN();
    
	public void closeReceiptTRN();
    
	public void deleteReceiptTRN();
    
	public void exportReceiptsTRN();
}
