package com.drgeb.receiptentry.sm.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.drgeb.receiptentry.sm.action.SyncStateAction;
import com.drgeb.receiptentry.sm.ReceiptState;
import com.drgeb.receiptentry.sm.ReceiptWO;

public class SyncStateActionImpl implements SyncStateAction {
    private static Logger logger = LogManager.getLogger(SyncStateActionImpl.class);
    @Override
    public void updateState(ReceiptWO receiptWO, ReceiptState newState) {
	receiptWO.getReceipt().setState(newState);
    }

}
