package com.drgeb.receiptentry.sm;

import com.drgeb.receiptentry.sm.action.CloseReceiptAction;
import com.drgeb.receiptentry.sm.action.CreateReceiptAction;
import com.drgeb.receiptentry.sm.action.DeleteReceiptAction;
import com.drgeb.receiptentry.sm.action.EditReceiptAction;
import com.drgeb.receiptentry.sm.action.ExportReceiptAction;
import com.drgeb.receiptentry.sm.action.SaveReceiptAction;
import com.drgeb.receiptentry.sm.action.SyncStateAction;
import com.drgeb.receiptentry.sm.action.ViewReceiptAction;
import com.drgeb.receiptentry.bo.Receipt;

/**
 * All the actions for the order object state machine
 *
 * @author Dr. Gerald E. Bennett Following architectural pattern of Jason
 *         Zhicheng Li (jason@lizjason.com)
 */
public interface ReceiptActions {

    public void createAction(ReceiptWO receipt);

    public void viewAction(ReceiptWO receipt);

    public void editAction(ReceiptWO receipt);

    public void deleteAction(ReceiptWO receipt);

    public void exportAction(ReceiptWO receipt);

    public void saveAction(ReceiptWO receipt);

    public void closeAction(ReceiptWO receipt);

    public void updateState(ReceiptWO receipt, ReceiptState newState);

    public void setCreateReceiptAction(CreateReceiptAction createReceiptAction);

    public void setDeleteReceiptAction(DeleteReceiptAction deleteReceiptAction);

    public void setEditReceiptAction(EditReceiptAction editReceiptAction);

    public void setSaveReceiptAction(SaveReceiptAction saveReceiptAction);

    public void setViewReceiptAction(ViewReceiptAction viewReceiptAction);

    public void setExportReceiptAction(ExportReceiptAction exportReceiptAction);

    public void setCloseReceiptAction(CloseReceiptAction closeReceiptAction);
}
