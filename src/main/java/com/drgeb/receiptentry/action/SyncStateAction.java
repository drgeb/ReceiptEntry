package com.drgeb.receiptentry.action;

import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.sm.ReceiptState;

/** 
 * Synchronize the Order state with 
 * the current state in the  
 * state machine. This action is not 
 * a business action. 
 */

public interface SyncStateAction {
    void updateState(Receipt receipt, ReceiptState newState);
}
