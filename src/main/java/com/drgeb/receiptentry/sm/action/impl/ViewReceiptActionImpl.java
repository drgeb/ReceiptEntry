package com.drgeb.receiptentry.sm.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.ViewReceiptAction;

public class ViewReceiptActionImpl implements ViewReceiptAction {
	private Logger logger = LoggerFactory.getLogger(ViewReceiptActionImpl.class);
	@Override
	public void viewAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
		logger.info("viewAction");
	}

}
