package com.drgeb.receiptentry.sm.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.DeleteReceiptAction;

public class DeleteReceiptActionImpl implements DeleteReceiptAction {
    private static Logger logger = LogManager.getLogger(DeleteReceiptActionImpl.class);
	@Override
	public void deleteAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("deleteAction");
	}

}
