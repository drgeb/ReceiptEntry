package com.drgeb.receiptentry.sm.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.CloseReceiptAction;

public class CloseReceiptActionImpl implements CloseReceiptAction {
    private static Logger logger = LogManager.getLogger(CloseReceiptActionImpl.class);
	@Override
	public void closeAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("closeAction");
	}

}
