package com.drgeb.receiptentry.vw.receipttable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.bo.registrations.boundary.RegistrationService;
import com.drgeb.receiptentry.vw.entry.EntryPresenter;
import com.drgeb.receiptentry.vw.entry.EntryView;

public class ReceipttablePresenter  extends Control implements Initializable{
    
	@FXML
	Button create;

	@FXML
	Button read;
	
	@FXML
	Button update;

	@FXML
	Button delete;
	
	@FXML
	TableView <Receipt> receiptsTable;
	private ObservableList<Receipt> receipts;
	private BooleanProperty editingStarted;
	private ObjectProperty<Receipt> deletedReceipt;

	private EntryView entryView;

	private EntryPresenter entryPresenter;
	
    @Inject
    RegistrationService service;
    
    private ObjectProperty<Receipt> selectedAttendee;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		final ChangeListener<Receipt> storingListener = new ChangeListener<Receipt>() {
            @Override
            public void changed(ObservableValue<? extends Receipt> ov, Receipt old, Receipt newReceipt) {
                if (newReceipt != null) {
                    service.save(newReceipt);
                    loadFromStore();
                }
            }
        };
        
//        this.selectedReceipt = new SimpleObjectProperty<>();

//        this.receipts = new SimpleObjectProperty<>();
//        this.receipts.addListener(storingListener);
        
//        this.receipts = FXCollections.observableArrayList();
//        this.editingStarted = new SimpleBooleanProperty();
//        this.deletedReceipt = new SimpleObjectProperty<>();
        prepareTable();
        registerListeners();
	}

	 void createPanes() {
		
     }
	 
	private void registerListeners() {
		// TODO Auto-generated method stub
		
	}

	private void prepareTable() {
		// TODO Auto-generated method stub
		
	}

	@FXML
	private void createAction(ActionEvent event) {
		//create stage which has set stage style transparent
         Stage stage = new Stage(StageStyle.UTILITY);
        //create root node of scene, i.e. group
        EntryView entryView = new EntryView((f)->stage);
        Scene scene = new Scene(entryView.getView());
        stage.setScene(scene);
        //center stage on screen
        stage.centerOnScreen();
        stage.show();
	}

	@FXML
	private void viewAction(ActionEvent event) {
	}
	@FXML
	private void editAction(ActionEvent event) {
	}
	@FXML
	private void deleteAction(ActionEvent event) {
	}

    void add(Receipt newReceipt) {
    }
    
    void loadFromStore() {

        List<Receipt> all = service.all();
        for (Receipt receipt : all) {
            add(receipt);
        }
    }
}
