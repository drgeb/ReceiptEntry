package com.drgeb.receiptentry.vw.entry;

import java.net.URL;
import java.util.ResourceBundle;

import javax.inject.Inject;

import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.bo.registrations.boundary.RegistrationService;

import javafx.scene.control.DatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EntryPresenter  implements Initializable {

	@Inject
	Stage stage;
	
	@FXML
	TextField id;
	
	@FXML
	TextField vendor;
	
	@FXML
	DatePicker date;
	
	@FXML
	TextField amount;
	
    @Inject
    RegistrationService registrationService;

    Receipt receipt;
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	this.receipt=new Receipt();
    	System.out.println("receipt initialized");
	}
	
	@FXML
	public void saveAction(ActionEvent event) {
		registrationService.save(receipt);
	}
	
	@FXML
	public void closeAction(ActionEvent event) {
		stage.close();
	}
}
