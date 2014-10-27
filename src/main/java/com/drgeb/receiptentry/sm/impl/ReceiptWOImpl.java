package com.drgeb.receiptentry.sm.impl;

/**
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/
import javax.inject.Inject;

import com.drgeb.receiptentry.sm.action.CloseReceiptAction;
import com.drgeb.receiptentry.sm.action.CreateReceiptAction;
import com.drgeb.receiptentry.sm.action.DeleteReceiptAction;
import com.drgeb.receiptentry.sm.action.EditReceiptAction;
import com.drgeb.receiptentry.sm.action.ExportReceiptAction;
import com.drgeb.receiptentry.sm.action.SaveReceiptAction;
import com.drgeb.receiptentry.sm.action.ViewReceiptAction;
import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.bo.registrations.boundary.RegistrationService;
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

    @Inject
    RegistrationService registrationService;

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

    public void createAction(ReceiptWO receipt) {
	receiptActions.createAction(receipt);
    }

    public void viewAction(ReceiptWO receipt) {
	receiptActions.viewAction(receipt);
    }

    public void editAction(ReceiptWO receipt) {
	receiptActions.editAction(receipt);
    }

    public void deleteAction(ReceiptWO receipt) {
	receiptActions.deleteAction(receipt);
    }

    public void exportAction(ReceiptWO receipt) {
	receiptActions.exportAction(receipt);
    }

    public void saveAction(ReceiptWO receipt) {
	receiptActions.saveAction(receipt);
    }

    public void closeAction(ReceiptWO receipt) {
	receiptActions.closeAction(receipt);
    }

    public void updateState(ReceiptWO receipt, ReceiptState newState) {
	receiptActions.updateState(receipt, newState);
    }

    public void setCreateReceiptAction(CreateReceiptAction createReceiptAction) {
	this.createReceiptAction = createReceiptAction;
    }

    public void setDeleteReceiptAction(DeleteReceiptAction deleteReceiptAction) {
	this.deleteReceiptAction = deleteReceiptAction;
    }

    public void setEditReceiptAction(EditReceiptAction editReceiptAction) {
	this.editReceiptAction = editReceiptAction;
    }

    public void setSaveReceiptAction(SaveReceiptAction saveReceiptAction) {
	this.saveReceiptAction = saveReceiptAction;
    }

    public void setViewReceiptAction(ViewReceiptAction viewReceiptAction) {
	this.viewReceiptAction = viewReceiptAction;
    }

    public void setExportReceiptAction(ExportReceiptAction exportReceiptAction) {
	this.exportReceiptAction = exportReceiptAction;
    }

    public void setCloseReceiptAction(CloseReceiptAction closeReceiptAction) {
	this.closeReceiptAction = closeReceiptAction;
    }

    // DEFINE TRANSITIONS
    public void saveReceiptTRN() {
	//TODO Figure out Injecion and move this code to SaveReceiptActionImpl
	//BLOCK
	if(registrationService==null){
	    registrationService=new RegistrationService();
	    registrationService.init();
	}
	registrationService.save(receipt);
	//BLOCK
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

    public void createTRN() {
	receiptTransitions.createTRN();
    }

    public void viewTRN() {
	receiptTransitions.viewTRN();
    }

    public void editTRN() {
	receiptTransitions.editTRN();
    }

    public void deleteTRN() {
	receiptTransitions.deleteTRN();
    }

    public void exportTRN() {
	receiptTransitions.exportTRN();
    }

    public String getVendor() {
	return this.receipt.getVendor();
    }

}
