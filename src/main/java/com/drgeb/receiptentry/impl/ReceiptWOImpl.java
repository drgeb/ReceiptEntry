package com.drgeb.receiptentry.impl;

/**
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/
import com.drgeb.receiptentry.action.CloseReceiptAction;
import com.drgeb.receiptentry.action.CreateReceiptAction;
import com.drgeb.receiptentry.action.DeleteReceiptAction;
import com.drgeb.receiptentry.action.EditReceiptAction;
import com.drgeb.receiptentry.action.ExportReceiptAction;
import com.drgeb.receiptentry.action.SaveReceiptAction;
import com.drgeb.receiptentry.action.SyncStateAction;
import com.drgeb.receiptentry.action.ViewReceiptAction;
import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.sm.ReceiptActions;
import com.drgeb.receiptentry.sm.ReceiptConditions;
import com.drgeb.receiptentry.sm.ReceiptState;
import com.drgeb.receiptentry.sm.ReceiptTransitions;
import com.drgeb.receiptentry.sm.ReceiptWO;


public class ReceiptWOImpl implements ReceiptWO {
	private Receipt receipt;
	private ReceiptActions receiptActions;
	private ReceiptConditions receiptConditions;
	private ReceiptTransitions receiptTransitions;

	private CloseReceiptAction closeReceiptAction;
	private ExportReceiptAction exportReceiptAction;
	private ViewReceiptAction viewReceiptAction;
	private SaveReceiptAction saveReceiptAction;
	private EditReceiptAction editReceiptAction;
	private DeleteReceiptAction deleteReceiptAction;
	private CreateReceiptAction createReceiptAction;

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Receipt getReceipt() {
		return this.receipt;
	}

	public void setReceiptActions(ReceiptActions receiptActions) {
		this.receiptActions = receiptActions;
	}

	public void setReceiptConditions(ReceiptConditions receiptConditions) {
		this.receiptConditions = receiptConditions;
	}

	public void setReceiptTransitions(ReceiptTransitions receiptTransitions) {
		this.receiptTransitions = receiptTransitions;
	}

	public void createAction(Receipt receipt) {
		receiptActions.createAction(receipt);
	}

	public void viewAction(Receipt receipt) {
		receiptActions.viewAction(receipt);
	}

	public void editAction(Receipt receipt) {
		receiptActions.editAction(receipt);
	}

	public void deleteAction(Receipt receipt) {
		receiptActions.deleteAction(receipt);
	}

	public void exportAction(Receipt receipt) {
		receiptActions.exportAction(receipt);
	}

	public void saveAction(Receipt receipt) {
		receiptActions.saveAction(receipt);
	}

	public void closeAction(Receipt receipt) {
		receiptActions.closeAction(receipt);
	}

	@Override
	public void updateState(Receipt receipt, ReceiptState newState) {
	    receiptActions.updateState(receipt, newState);
	}

	@Override
	public void setCreateReceiptAction(CreateReceiptAction createReceiptAction) {
		this.createReceiptAction = createReceiptAction;
	}

	@Override
	public void setDeleteReceiptAction(DeleteReceiptAction deleteReceiptAction) {
		this.deleteReceiptAction = deleteReceiptAction;
	}

	@Override
	public void setEditReceiptAction(EditReceiptAction editReceiptAction) {
		this.editReceiptAction = editReceiptAction;
	}

	@Override
	public void setSaveReceiptAction(SaveReceiptAction saveReceiptAction) {
		this.saveReceiptAction = saveReceiptAction;
	}

	@Override
	public void setViewReceiptAction(ViewReceiptAction viewReceiptAction) {
		this.viewReceiptAction = viewReceiptAction;
	}

	@Override
	public void setExportReceiptAction(ExportReceiptAction exportReceiptAction) {
		this.exportReceiptAction = exportReceiptAction;
	}

	@Override
	public void setCloseReceiptAction(CloseReceiptAction closeReceiptAction) {
		this.closeReceiptAction = closeReceiptAction;
	}

	//DEFINE TRANSITIONS
	public void saveReceiptTRN() {
		receiptTransitions.saveReceiptTRN();
	}

	public void closeReceiptTRN() {
		receiptTransitions.closeReceiptTRN();
	}

	public void deleteReceiptTRN() {
		receiptTransitions.deleteReceiptTRN();
	}

	public void exportReceiptsTRN() {
		receiptTransitions.exportReceiptsTRN();
	}
	@Override
	public void createTRN() {
	    receiptTransitions.createTRN();
	}

	@Override
	public void viewTRN() {
	    receiptTransitions.viewTRN();
	}

	@Override
	public void editTRN() {
	    receiptTransitions.editTRN();
	}

	@Override
	public void deleteTRN() {
	    receiptTransitions.deleteTRN();
	}

	@Override
	public void exportTRN() {
	    receiptTransitions.exportTRN();
	}		
	
}
