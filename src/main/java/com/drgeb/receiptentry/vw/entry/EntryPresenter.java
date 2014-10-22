package com.drgeb.receiptentry.vw.entry;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.inject.Inject;

import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.bo.registrations.boundary.RegistrationService;
import com.drgeb.receiptentry.vw.receipttable.ReceipttablePresenter;

import javafx.scene.control.DatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EntryPresenter  implements Initializable {
	@FXML
	TextField id;
	
	@FXML
	TextField vendor;
	
	@FXML
	DatePicker date;
	
	@FXML
	TextField amount;
	
	@SuppressWarnings("rawtypes")
	@Inject
	HashMap injectionContext;
	
	private Stage stage;
    private Receipt receipt;

	private ReceipttablePresenter receipttablePresenter;

	@Inject
    RegistrationService registrationService;

    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	stage = (Stage) injectionContext.get(Stage.class);
    	receipt = (Receipt) injectionContext.get(Receipt.class);
    	receipttablePresenter=(ReceipttablePresenter) injectionContext.get(ReceipttablePresenter.class);

		id.setText(receipt.getReceiptId());
		vendor.setText(receipt.getVendor());
		date.setValue(receipt.getPurchaseDate());
		amount.setText(new Double(receipt.getAmount()).toString());
	}

	@FXML
	public void saveAction(ActionEvent event) {
		receipt.setVendor(vendor.getText());
		receipt.setPurchaseDate(date.getValue());
		receipt.setAmount(Double.valueOf(amount.getText()).doubleValue());
		registrationService.save(receipt);
		stage.close();
		receipttablePresenter.loadFromStore();
	}
	
	@FXML
	public void closeAction(ActionEvent event) {
		stage.close();
	}
}
