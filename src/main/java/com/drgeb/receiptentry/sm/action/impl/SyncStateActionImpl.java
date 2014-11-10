package com.drgeb.receiptentry.sm.action.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drgeb.receiptentry.sm.action.SyncStateAction;
import com.drgeb.receiptentry.sm.ReceiptState;
import com.drgeb.receiptentry.sm.ReceiptWO;

public class SyncStateActionImpl implements SyncStateAction {
	private Logger logger = LoggerFactory.getLogger(SyncStateActionImpl.class);
    @Override
    public void updateState(ReceiptWO receiptWO, ReceiptState newState) {
	receiptWO.getReceipt().setState(newState);
    }

}
