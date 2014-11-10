package com.drgeb.receiptentry.sm.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.CloseReceiptAction;

public class CloseReceiptActionImpl implements CloseReceiptAction {
	private Logger logger = LoggerFactory.getLogger(CloseReceiptActionImpl.class);
	@Override
	public void closeAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("closeAction");
	}

}
