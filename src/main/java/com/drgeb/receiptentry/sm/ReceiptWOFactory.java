package com.drgeb.receiptentry.sm;

/**
*
* @author Dr. Gerald E. Bennett
* Following architectural pattern of Jason Zhicheng Li (jason@lizjason.com)
*/
public interface ReceiptWOFactory {
	ReceiptWO createReceiptWO(String receiptId);
}
