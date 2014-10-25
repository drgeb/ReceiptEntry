package com.drgeb.receiptentry.impl;

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
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/
import com.drgeb.receiptentry.sm.ReceiptActions;
import com.drgeb.receiptentry.sm.ReceiptState;

public class ReceiptActionsImpl implements ReceiptActions {
    private CreateReceiptAction createReceiptAction;
    private ViewReceiptAction viewReceiptAction;
    private EditReceiptAction editReceiptAction;
    private DeleteReceiptAction deleteReceiptAction;
    private ExportReceiptAction exportReceiptAction;
    private SaveReceiptAction saveReceiptAction;
    private CloseReceiptAction closeReceiptAction;
    private SyncStateAction syncStateAction;

    public void createAction(Receipt receipt) {
	this.createReceiptAction.createAction(receipt);
    }

    public void viewAction(Receipt receipt) {
	this.viewReceiptAction.viewAction(receipt);
    }

    public void editAction(Receipt receipt) {
	this.editReceiptAction.editAction(receipt);
    }

    public void deleteAction(Receipt receipt) {
	this.deleteReceiptAction.deleteAction(receipt);
    }

    public void exportAction(Receipt receipt) {
	this.exportReceiptAction.exportAction(receipt);
    }

    public void saveAction(Receipt receipt) {
	this.saveReceiptAction.saveAction(receipt);
    }

    @Override
    public void closeAction(Receipt receipt) {
	this.closeReceiptAction.closeAction(receipt);
    }

    @Override
    public void setCreateReceiptAction(CreateReceiptAction createReceiptAction) {
	this.createReceiptAction = createReceiptAction;
    }

    @Override
    public void setViewReceiptAction(ViewReceiptAction viewReceiptAction) {
	this.viewReceiptAction = viewReceiptAction;
    }
    
    @Override
    public void setEditReceiptAction(EditReceiptAction editReceiptAction) {
	this.editReceiptAction = editReceiptAction;
    }

    @Override
    public void setDeleteReceiptAction(DeleteReceiptAction deleteReceiptAction) {
	this.deleteReceiptAction = deleteReceiptAction;
    }

    @Override
    public void setExportReceiptAction(ExportReceiptAction exportReceiptAction) {
	this.exportReceiptAction = exportReceiptAction;
    }

    @Override
    public void setSaveReceiptAction(SaveReceiptAction saveReceiptAction) {
	this.saveReceiptAction = saveReceiptAction;
    }

    @Override
    public void setCloseReceiptAction(CloseReceiptAction closeReceiptAction) {
	this.closeReceiptAction = closeReceiptAction;
    }

    @Override
    public void updateState(Receipt receipt, ReceiptState newState) {
	this.syncStateAction.updateState(receipt,newState);
    }

    public void setSyncStateAction(SyncStateAction syncStateAction) {
	this.syncStateAction = syncStateAction;
    }

}
