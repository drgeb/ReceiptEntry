package com.drgeb.receiptentry.sm;

import com.drgeb.receiptentry.bo.Receipt;

/**
*
* @author Dr. Gerald E. Bennett
* Following architectural pattern of Jason Zhicheng Li (jason@lizjason.com)
*/
public interface ReceiptWOFactory {
	ReceiptWO createReceiptWO(String receiptId);
	ReceiptWO createReceiptWO(Receipt receipt);
}
