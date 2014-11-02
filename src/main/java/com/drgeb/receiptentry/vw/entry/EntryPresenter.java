package com.drgeb.receiptentry.vw.entry;

/**
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/
import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.inject.Inject;

import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.sm.ReceiptState;
import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.vw.receipttable.ReceiptTablePresenter;

import org.springframework.context.annotation.Configuration;

public class EntryPresenter implements Initializable {
    @FXML
    TextField id;

    @FXML
    TextField vendor;

    @FXML
    DatePicker date;

    @FXML
    TextField updateDate;
    
    @FXML
    TextField amount;

    @FXML
    TextField salesTax;
    
    @SuppressWarnings("rawtypes")
    @Inject
    HashMap injectionContext;

    @FXML
    TextField location;

    @FXML
    ChoiceBox<String> paymentType;

    @FXML
    ChoiceBox<String> currency;

    @FXML
    TextArea notes;

    @FXML
    Button saveButton;
    
    @FXML
    CheckBox paid;
    
    @FXML
    CheckBox reimbursable;
    
    @FXML
    CheckBox reconciled;
   
    @FXML
    Button importPDFButton;
    
    private Stage stage;
    private ReceiptWO receiptWO;

    private ReceiptTablePresenter receipttablePresenter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	stage = (Stage) injectionContext.get(Stage.class);
	receiptWO = (ReceiptWO) injectionContext.get(ReceiptWO.class);
	
	Receipt receipt = receiptWO.getReceipt();
	
	receipttablePresenter = (ReceiptTablePresenter) injectionContext
		.get(ReceiptTablePresenter.class);

	this.id.setText(receipt.getReceiptId());
	this.vendor.setText(receipt.getVendor());
	this.date.setValue(receipt.getPurchaseDate());
	this.updateDate.setText(receipt.getUpdateDate().toString());
	this.amount.setText(new Double(receipt.getAmount()).toString());
	this.salesTax.setText(new Double(receipt.getSalesTax()).toString());
	//TODO implement currency & payment
	String receiptCurrency=receipt.getCurrency();
	String receiptPaymentType=receipt.getPaymentType();
	//currency.getItems().addAll("Dog", "Cat", "Horse");
	currency.getSelectionModel().select(receiptCurrency);
	paymentType.getSelectionModel().select(receiptPaymentType);
	this.location.setText(receipt.getLocation());
	this.reimbursable.setSelected(receipt.getReimbursable());
	this.paid.setSelected(receipt.getPaid());
	this.reconciled.setSelected(receipt.getReconciled());
	this.notes.setText(receipt.getNotes());

	if(receiptWO.getReceipt().getState()==ReceiptState.ViewState){
	    saveButton.setVisible(false); 
	    importPDFButton.setVisible(false);
	    //Make everything uneditable
	    this.vendor.setEditable(false);
	    this.date.setEditable(false);
	    this.amount.setEditable(false);
	    this.salesTax.setEditable(false);
	    this.currency.setDisable(true);
	    this.paymentType.setDisable(true);
	    this.location.setEditable(false);
	    this.reimbursable.setDisable(true);
	    this.paid.setDisable(true);
	    this.reconciled.setDisable(true);
	    this.notes.setEditable(false);
	} else
	{
	    saveButton.setVisible(true);
	}
    }

    @FXML
    public void saveAction(ActionEvent event) {
	Receipt receipt = receiptWO.getReceipt();
	receipt.setVendor(vendor.getText());
	//TODO Need to implement setting Author part of General Settings
	//TODO The Author will be otained from User Login information
	String author="Gerald E. Bennett";
	receipt.setAuthor(author);
	receipt.setPurchaseDate(date.getValue());
	receipt.setUpdateDate(LocalDateTime.now());
	receipt.setAmount(Double.valueOf(amount.getText()).doubleValue());
	receipt.setSalesTax(Double.valueOf(salesTax.getText()).doubleValue());
	String currencyText=(String) currency.getValue();
	receipt.setCurrency(currencyText);
	String paymentTypeText=(String) paymentType.getValue();	
	receipt.setPaymentType(paymentTypeText);
	receipt.setLocation(location.getText());
	receipt.setReimbursable(reimbursable.selectedProperty().get());
	receipt.setPaid(paid.selectedProperty().get());
	receipt.setReconciled(reconciled.selectedProperty().get());
	receipt.setNotes(notes.getText());
	
	receiptWO.saveReceiptTRN();
	stage.close();
	receipttablePresenter.loadFromStore();
    }

    @FXML
    public void closeAction(ActionEvent event) {
	receiptWO.closeReceiptTRN();
	stage.close();
    }

    @FXML
    public void importPDFAction(ActionEvent event) {
	// TODO implement
    }
}
