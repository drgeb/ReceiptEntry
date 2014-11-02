package com.drgeb.receiptentry.sm.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.CreateReceiptAction;

public class CreateReceiptActionImpl implements CreateReceiptAction {
    private static Logger logger = LogManager.getLogger(CreateReceiptActionImpl.class);
	@Override
	public void createAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("createAction");
	}

}
