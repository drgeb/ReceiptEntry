package com.drgeb.receiptentry.sm.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.SaveReceiptAction;

public class SaveReceiptActionImpl implements SaveReceiptAction {
	private Logger logger = LoggerFactory.getLogger(SaveReceiptActionImpl.class);
	@Override
	public void saveAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("saveAction");
	}

}
