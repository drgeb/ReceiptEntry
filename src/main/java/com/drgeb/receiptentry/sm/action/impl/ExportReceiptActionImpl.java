package com.drgeb.receiptentry.sm.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.ExportReceiptAction;

public class ExportReceiptActionImpl implements ExportReceiptAction {
	private Logger logger = LoggerFactory.getLogger(ExportReceiptActionImpl.class);
	@Override
	public void exportAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("exportAction");
	}

}
