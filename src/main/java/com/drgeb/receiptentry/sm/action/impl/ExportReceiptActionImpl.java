package com.drgeb.receiptentry.sm.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.ExportReceiptAction;

public class ExportReceiptActionImpl implements ExportReceiptAction {
    private static Logger logger = LogManager.getLogger(ExportReceiptActionImpl.class);
	@Override
	public void exportAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("exportAction");
	}

}
