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

import javafx.beans.property.BooleanProperty;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.bo.registrations.boundary.RegistrationService;
import com.drgeb.receiptentry.sm.ReceiptWOContext;
import com.drgeb.receiptentry.vw.entry.EntryView;
import com.drgeb.receiptentry.sm.ReceiptActions;

public class ReceipttablePresenter extends Control implements Initializable,
		ReceiptActions {

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
	TableView<Receipt> receiptsTable;

	@FXML
	TableColumn receiptIDColumn;

	@FXML
	TableColumn vendorColumn;

	@FXML
	TableColumn dateColumn;

	@FXML
	TableColumn amountColumn;

	private ObservableList<Receipt> receipts;
	private ObjectProperty<Receipt> deletedReceipt;

	@Inject
	RegistrationService service;

	private SimpleObjectProperty<Object> selectedReceipt;

	private ReceiptWOContext _fsm;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.selectedReceipt = new SimpleObjectProperty<>();
		this.receipts = FXCollections.observableArrayList();
		new SimpleBooleanProperty();
		this.deletedReceipt = new SimpleObjectProperty<>();

		receiptIDColumn.setCellValueFactory(new PropertyValueFactory(
				"receiptId"));
		vendorColumn.setCellValueFactory(new PropertyValueFactory("vendor"));
		dateColumn
				.setCellValueFactory(new PropertyValueFactory("purchaseDate"));
		amountColumn.setCellValueFactory(new PropertyValueFactory("amount"));

		loadFromStore();
		receiptsTable.setItems(this.receipts);
		receiptsTable.getSelectionModel()
				.setSelectionMode(SelectionMode.SINGLE);
		registerListeners();
		buttonEnablement();
		// ReceiptWO owner = new ReceiptWO();

		// _fsm = new ReceiptWOContext(owner);
		// Uncomment to see debug output.
		// _fsm.setDebugFlag(true);
	}

	private void buttonEnablement() {
		Receipt selectedItem = receiptsTable.getSelectionModel()
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

	private void initiateEntry(Receipt receipt) {
		// create stage which has set stage style transparent
		Stage stage = new Stage(StageStyle.UTILITY);

		@SuppressWarnings("rawtypes")
		HashMap<Class, Object> contextMap = new HashMap<Class, Object>();
		contextMap.put(Receipt.class, receipt);
		contextMap.put(Stage.class, stage);
		contextMap.put(ReceipttablePresenter.class, this);

		EntryView entryView = new EntryView((f) -> contextMap);
		Scene scene = new Scene(entryView.getView());
		stage.setScene(scene);
		// center stage on screen
		stage.centerOnScreen();
		receiptsTable.getSelectionModel().clearSelection();
		stage.show();
	}

	@FXML
	private void createAction(ActionEvent event) {
		createAction();
	}

	@FXML
	private void viewAction(ActionEvent event) {
		viewAction();
	}

	@FXML
	private void editAction(ActionEvent event) {
		editAction();
	}

	@FXML
	private void deleteAction(ActionEvent event) {
		deleteAction();
	}

	@FXML
	private void exportAction(ActionEvent event) {
		exportAction();
	}

	public void add(Receipt receipt) {
		this.receipts.add(receipt);
	}

	public void loadFromStore() {
		this.clearAll();
		List<Receipt> all = service.all();
		for (Receipt receipt : all) {
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
					Receipt selectedItem = receiptsTable.getSelectionModel()
							.getSelectedItem();
					if (selectedItem != null) {
						fireReceiptsDeleted(selectedItem);
					}
				}
			}
		});

		ChangeListener<Receipt> deletionListener = new ChangeListener<Receipt>() {
			@Override
			public void changed(ObservableValue<? extends Receipt> observable,
					Receipt oldValue, Receipt newValue) {
				if (newValue != null) {
					service.remove(newValue);
					loadFromStore();
				}
			}
		};

		ChangeListener<Receipt> selectionListener = new ChangeListener<Receipt>() {
			@Override
			public void changed(ObservableValue<? extends Receipt> observable,
					Receipt oldValue, Receipt newValue) {
				selectedReceipt.set(newValue);
				buttonEnablement();
			};
		};

		this.deletedAttendeeProperty().addListener(deletionListener);
		this.selectedAttendeeProperty().addListener(selectionListener);
	}

	public ObjectProperty<Receipt> deletedAttendeeProperty() {
		return this.deletedReceipt;
	}

	public ReadOnlyObjectProperty<Receipt> selectedAttendeeProperty() {
		return this.receiptsTable.getSelectionModel().selectedItemProperty();
	}

	private void fireReceiptsDeleted(Receipt deletedItem) {
		receiptsTable.getSelectionModel().clearSelection();
		this.deletedReceipt.set(deletedItem);
	}

	public void createAction() {
		Receipt receipt = new Receipt();
		initiateEntry(receipt);
	}

	public void viewAction() {
		Receipt selectedItem = receiptsTable.getSelectionModel()
				.getSelectedItem();
		initiateEntry(selectedItem);
	}

	public void editAction() {
		Receipt selectedItem = receiptsTable.getSelectionModel()
				.getSelectedItem();
		initiateEntry(selectedItem);
	}

	public void deleteAction() {
		Receipt selectedItem = receiptsTable.getSelectionModel()
				.getSelectedItem();
		fireReceiptsDeleted(selectedItem);
		receiptsTable.getSelectionModel().clearSelection();
	}

	public void exportAction() {
		// TODO Implement export data to CVS
		// 1. Ask user for file location.
		// 2. Export the data to an Excel file.
	}

	@Override
	public void saveAction() {
	}

	@Override
	public void closeAction() {
	}
}
