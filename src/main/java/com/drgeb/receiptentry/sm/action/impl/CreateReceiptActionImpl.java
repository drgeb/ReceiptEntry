package com.drgeb.receiptentry.sm.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.CreateReceiptAction;

public class CreateReceiptActionImpl implements CreateReceiptAction {
	private Logger logger = LoggerFactory.getLogger(CreateReceiptActionImpl.class);
	@Override
	public void createAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("createAction");
	}

}
