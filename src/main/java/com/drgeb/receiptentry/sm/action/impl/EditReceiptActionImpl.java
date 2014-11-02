package com.drgeb.receiptentry.sm.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.EditReceiptAction;

public class EditReceiptActionImpl implements EditReceiptAction {
    private static Logger logger = LogManager.getLogger(EditReceiptActionImpl.class);
	@Override
	public void editAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("editAction");
	}

}
