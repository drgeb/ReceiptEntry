package com.drgeb.receiptentry.sm.action;

import com.drgeb.receiptentry.sm.ReceiptState;
import com.drgeb.receiptentry.sm.ReceiptWO;

/** 
 * Synchronize the Order state with 
 * the current state in the  
 * state machine. This action is not 
 * a business action. 
 */

public interface SyncStateAction {
    void updateState(ReceiptWO receipt, ReceiptState newState);
}
