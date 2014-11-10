package com.drgeb.receiptentry.sm.impl;

/**
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/
import com.drgeb.receiptentry.sm.ReceiptActions;
import com.drgeb.receiptentry.sm.ReceiptState;
import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.action.CloseReceiptAction;
import com.drgeb.receiptentry.sm.action.CreateReceiptAction;
import com.drgeb.receiptentry.sm.action.DeleteReceiptAction;
import com.drgeb.receiptentry.sm.action.EditReceiptAction;
import com.drgeb.receiptentry.sm.action.ExportReceiptAction;
import com.drgeb.receiptentry.sm.action.SaveReceiptAction;
import com.drgeb.receiptentry.sm.action.SyncStateAction;
import com.drgeb.receiptentry.sm.action.ViewReceiptAction;

public class ReceiptActionsImpl implements ReceiptActions {
    private CreateReceiptAction createReceiptAction;
    private ViewReceiptAction viewReceiptAction;
    private EditReceiptAction editReceiptAction;
    private DeleteReceiptAction deleteReceiptAction;
    private ExportReceiptAction exportReceiptAction;
    private SaveReceiptAction saveReceiptAction;
    private CloseReceiptAction closeReceiptAction;
    private SyncStateAction syncStateAction;

    public void createAction(ReceiptWO receipt) {
	this.createReceiptAction.createAction(receipt);
    }

    public void viewAction(ReceiptWO receipt) {
	this.viewReceiptAction.viewAction(receipt);
    }

    public void editAction(ReceiptWO receipt) {
	this.editReceiptAction.editAction(receipt);
    }

    public void deleteAction(ReceiptWO receipt) {
	this.deleteReceiptAction.deleteAction(receipt);
    }

    public void exportAction(ReceiptWO receipt) {
	this.exportReceiptAction.exportAction(receipt);
    }

    public void saveAction(ReceiptWO receipt) {
	this.saveReceiptAction.saveAction(receipt);
    }

    @Override
    public void closeAction(ReceiptWO receipt) {
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
    public void updateState(ReceiptWO receipt, ReceiptState newState) {
	this.syncStateAction.updateState(receipt,newState);
    }

    public void setSyncStateAction(SyncStateAction syncStateAction) {
	this.syncStateAction = syncStateAction;
    }

}
