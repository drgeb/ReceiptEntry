package com.drgeb.receiptentry.sm.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drgeb.receiptentry.App;
import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.ViewReceiptAction;

public class ViewReceiptActionImpl implements ViewReceiptAction {
    private static Logger logger = LogManager.getLogger(ViewReceiptActionImpl.class);
	@Override
	public void viewAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
		logger.info("viewAction");
	}

}
