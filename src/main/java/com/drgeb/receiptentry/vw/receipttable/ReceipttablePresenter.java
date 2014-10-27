package com.drgeb.receiptentry.vw.receipttable;

/**
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import com.drgeb.receiptentry.sm.impl.ReceiptWOFactoryImpl;
//import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.bo.registrations.boundary.RegistrationService;
import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.ReceiptWOFactory;
import com.drgeb.receiptentry.vw.entry.EntryView;

public class ReceipttablePresenter extends Control implements Initializable {
    @FXML
    Button create;

    @FXML
    Button view;

    @FXML
    Button edit;

    @FXML
    Button delete;

    @FXML
    Button export;

    @FXML
    TableView<ReceiptWO> receiptsTable;

    @FXML
    TableColumn<?, ?> receiptIDColumn;

    @FXML
    TableColumn<?, ?> vendorColumn;

    @FXML
    TableColumn<?, ?> dateColumn;

    @FXML
    TableColumn<?, ?> amountColumn;

    @FXML
    Label recordLabel;

    private ObservableList<ReceiptWO> receipts;
    private ObjectProperty<ReceiptWO> deletedReceipt;

    @Inject
    RegistrationService service;

    private SimpleObjectProperty<Object> selectedReceipt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	this.selectedReceipt = new SimpleObjectProperty<>();
	this.receipts = FXCollections.observableArrayList();
	new SimpleBooleanProperty();
	this.deletedReceipt = new SimpleObjectProperty<>();

	receiptIDColumn.setCellValueFactory(new ReceiptPropertyValueFactory(
		"receiptId"));
	vendorColumn.setCellValueFactory(new ReceiptPropertyValueFactory(
		"vendor"));
	dateColumn.setCellValueFactory(new ReceiptPropertyValueFactory(
		"purchaseDate"));
	amountColumn.setCellValueFactory(new ReceiptPropertyValueFactory(
		"amount"));

	loadFromStore();
	receiptsTable.setItems(this.receipts);
	receiptsTable.getSelectionModel()
		.setSelectionMode(SelectionMode.SINGLE);
	registerListeners();
	buttonEnablement();
    }

    private void buttonEnablement() {
	ReceiptWO selectedItem = receiptsTable.getSelectionModel()
		.getSelectedItem();
	if (selectedItem == null) {
	    create.setDisable(false);
	    view.setDisable(true);
	    edit.setDisable(true);
	    delete.setDisable(true);
	    export.setDisable(false);
	} else {
	    create.setDisable(false);
	    view.setDisable(false);
	    edit.setDisable(false);
	    delete.setDisable(false);
	    export.setDisable(false);
	}
    }

    private void initiateEntry(ReceiptWO receiptWO) {
	// create stage which has set stage style transparent
	Stage stage = new Stage(StageStyle.UTILITY);

	@SuppressWarnings("rawtypes")
	HashMap<Class, Object> contextMap = new HashMap<Class, Object>();
	contextMap.put(ReceiptWO.class, receiptWO);
	contextMap.put(Stage.class, stage);
	contextMap.put(ReceipttablePresenter.class, this);

	EntryView entryView = new EntryView((f) -> contextMap);
	Scene scene = new Scene(entryView.getView());
	stage.setScene(scene);
	// center stage on screen
	stage.centerOnScreen();
	receiptsTable.getSelectionModel().clearSelection();

	EventType<WindowEvent> eventType = WindowEvent.WINDOW_CLOSE_REQUEST;
	stage.addEventHandler(eventType, (WindowEvent t) -> {
	    receiptWO.closeReceiptTRN();
	});
	stage.show();
    }

    @FXML
    private void createAction(ActionEvent event) {
	// TODO use Factory to create ReceiptWO
	ReceiptWOFactory receiptWOFactory = new ReceiptWOFactoryImpl();
	ReceiptWO receiptWO = receiptWOFactory.createReceiptWO((String) null);
	receiptWO.createTRN();
	initiateEntry(receiptWO);
    }

    @FXML
    private void viewAction(ActionEvent event) {
	ReceiptWO selectedItem = receiptsTable.getSelectionModel()
		.getSelectedItem();
	selectedItem.viewTRN();
	initiateEntry(selectedItem);
    }

    @FXML
    private void editAction(ActionEvent event) {
	ReceiptWO selectedItem = receiptsTable.getSelectionModel()
		.getSelectedItem();
	selectedItem.editTRN();
	initiateEntry(selectedItem);
    }

    @FXML
    private void deleteAction(ActionEvent event) {
	ReceiptWO selectedItem = receiptsTable.getSelectionModel()
		.getSelectedItem();
	selectedItem.deleteTRN();
	fireReceiptsDeleted(selectedItem);
	receiptsTable.getSelectionModel().clearSelection();
    }

    @FXML
    private void exportAction(ActionEvent event) {
	// TODO Implement export data to CVS
	// 1. Ask user for file location.
	// 2. Export the data to an Excel file.
    }

    public void add(ReceiptWO receipt) {
	this.receipts.add(receipt);
    }

    public void loadFromStore() {
	this.clearAll();
	List<ReceiptWO> all = service.all();
	if(recordLabel!=null)recordLabel.setText("#: " + all.size());
	for (ReceiptWO receipt : all) {
	    add(receipt);
	}
    }

    public void clearAll() {
	this.receiptsTable.getItems().clear();
    }

    private void registerListeners() {
	this.receiptsTable.setOnKeyReleased(new EventHandler<KeyEvent>() {
	    @Override
	    public void handle(KeyEvent t) {
		if (t.getCode().equals(KeyCode.BACK_SPACE)) {
		    ReceiptWO selectedItem = receiptsTable.getSelectionModel()
			    .getSelectedItem();
		    if (selectedItem != null) {
			fireReceiptsDeleted(selectedItem);
		    }
		}
	    }
	});

	ChangeListener<ReceiptWO> deletionListener = new ChangeListener<ReceiptWO>() {
	    @Override
	    public void changed(
		    ObservableValue<? extends ReceiptWO> observable,
		    ReceiptWO oldValue, ReceiptWO newValue) {
		// TODO GET RID OF THIS CODE AND PLACE SOMEWHERE ELSE!
		if (newValue != null) {
		    service.remove(newValue.getReceipt());
		    loadFromStore();
		}
	    }
	};

	ChangeListener<ReceiptWO> selectionListener = new ChangeListener<ReceiptWO>() {
	    @Override
	    public void changed(
		    ObservableValue<? extends ReceiptWO> observable,
		    ReceiptWO oldValue, ReceiptWO newValue) {
		selectedReceipt.set(newValue);
		buttonEnablement();
	    };
	};

	this.deletedAttendeeProperty().addListener(deletionListener);
	this.selectedAttendeeProperty().addListener(selectionListener);
    }

    public ObjectProperty<ReceiptWO> deletedAttendeeProperty() {
	return this.deletedReceipt;
    }

    public ReadOnlyObjectProperty<ReceiptWO> selectedAttendeeProperty() {
	return this.receiptsTable.getSelectionModel().selectedItemProperty();
    }

    private void fireReceiptsDeleted(ReceiptWO deletedItem) {
	receiptsTable.getSelectionModel().clearSelection();
	this.deletedReceipt.set(deletedItem);
    }
}
