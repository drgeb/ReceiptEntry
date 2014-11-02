package com.drgeb.receiptentry.sm.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.SaveReceiptAction;

public class SaveReceiptActionImpl implements SaveReceiptAction {
    private static Logger logger = LogManager.getLogger(SaveReceiptActionImpl.class);
	@Override
	public void saveAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("saveAction");
	}

}
