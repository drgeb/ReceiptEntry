package com.drgeb.receiptentry.action.impl;

import com.drgeb.receiptentry.action.SyncStateAction;
import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.sm.ReceiptState;

public class SyncStateActionImpl implements SyncStateAction {

    @Override
    public void updateState(Receipt receipt, ReceiptState newState) {
	receipt.setState(newState);
    }

}
