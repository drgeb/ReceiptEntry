package com.drgeb.receiptentry.sm.action.impl;

import com.drgeb.receiptentry.sm.action.SyncStateAction;
import com.drgeb.receiptentry.sm.ReceiptState;
import com.drgeb.receiptentry.sm.ReceiptWO;

public class SyncStateActionImpl implements SyncStateAction {

    @Override
    public void updateState(ReceiptWO receiptWO, ReceiptState newState) {
	receiptWO.getReceipt().setState(newState);
    }

}
