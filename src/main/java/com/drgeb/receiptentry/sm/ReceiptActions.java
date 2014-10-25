package com.drgeb.receiptentry.sm;

import com.drgeb.receiptentry.action.CloseReceiptAction;
import com.drgeb.receiptentry.action.CreateReceiptAction;
import com.drgeb.receiptentry.action.DeleteReceiptAction;
import com.drgeb.receiptentry.action.EditReceiptAction;
import com.drgeb.receiptentry.action.ExportReceiptAction;
import com.drgeb.receiptentry.action.SaveReceiptAction;
import com.drgeb.receiptentry.action.SyncStateAction;
import com.drgeb.receiptentry.action.ViewReceiptAction;
import com.drgeb.receiptentry.bo.Receipt;

/**
* All the actions for the order object state machine 
*
* @author Dr. Gerald E. Bennett
* Following architectural pattern of Jason Zhicheng Li (jason@lizjason.com)
*/
public interface ReceiptActions {

    public void createAction(Receipt receipt);

    public void viewAction(Receipt receipt);

    public void editAction(Receipt receipt);

    public void deleteAction(Receipt receipt);

    public void exportAction(Receipt receipt);

    public void saveAction(Receipt receipt);

    public void closeAction(Receipt receipt);

    public void updateState(Receipt receipt, ReceiptState newState);

	public void setCreateReceiptAction(CreateReceiptAction createReceiptAction);

	public void setDeleteReceiptAction(DeleteReceiptAction deleteReceiptAction);

	public void setEditReceiptAction(EditReceiptAction editReceiptAction);

	public void setSaveReceiptAction(SaveReceiptAction saveReceiptAction);

	public void setViewReceiptAction(ViewReceiptAction viewReceiptAction);

	public void setExportReceiptAction(ExportReceiptAction exportReceiptAction);

	public void setCloseReceiptAction(CloseReceiptAction closeReceiptAction);	
}
