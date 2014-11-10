package com.drgeb.receiptentry.sm.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.DeleteReceiptAction;

public class DeleteReceiptActionImpl implements DeleteReceiptAction {
	private Logger logger = LoggerFactory.getLogger(DeleteReceiptActionImpl.class);
	@Override
	public void deleteAction(ReceiptWO receipt) {
		// TODO Auto-generated method stub
	    logger.info("deleteAction");
	}

}
