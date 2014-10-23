package com.drgeb.receiptentry.bo;

/**
*
* @author Dr. Gerald E. Bennett
*/
import java.time.LocalDate;
import java.util.UUID;

import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.drgeb.receiptentry.sm.ReceiptState;

@Entity
@NamedQueries({ @NamedQuery(name = Receipt.findAll, query = "SELECT a from Receipt a") })
public class Receipt {

	private static final long serialVersionUID = 1;

	public final static String PREFIX = "com.drgeb.receiptentry.bo.Mio.";
	public final static String findAll = PREFIX + "findAll";

	private StringProperty receiptId;
	private StringProperty vendorProperty;
	private StringProperty author;
	private ObjectProperty <ReceiptState> state;
	private ObjectProperty <LocalDate> purchasedDate;
	private ObjectProperty <LocalDate> createDate;
	private ObjectProperty <LocalDate> updateDate;
	private DoubleProperty amount;


	public Receipt() {
		this.receiptId = new SimpleStringProperty(UUID.randomUUID().toString());
		this.createDate=new SimpleObjectProperty<LocalDate>(LocalDate.now());

		this.vendorProperty=new SimpleStringProperty();
		this.author=new SimpleStringProperty();		
		this.state=new SimpleObjectProperty<ReceiptState>();
		this.purchasedDate=new SimpleObjectProperty<LocalDate>();
		this.updateDate=new SimpleObjectProperty<LocalDate>();
		this.amount = new SimpleDoubleProperty();
	}
	
    @Id
    public String getReceiptId() {
        return receiptId.get();
    }

    public void setReceiptId(String id) {
        this.receiptId.set(id);
    }

	public String getVendor() {
		return this.vendorProperty.get();
	}

	public void setVendor(String vendor) {
		this.vendorProperty.set(vendor);
	}
	
	public String getAuthor() {
		return this.author.get();
	}

	public void setAuthor(String author) {
		this.author.set(author);
	}

	public ReceiptState getState() {
		return (ReceiptState) this.state.get();
	}

	public void setState(ReceiptState state) {
		this.state.set(state);
	}

	public LocalDate getPurchaseDate() {
		return this.purchasedDate.get();
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchasedDate.set(purchaseDate);
	}

	public LocalDate getCreateDate() {
		return this.createDate.get();
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate.set(createDate);
	}

	public LocalDate getUpdateDate() {
		return this.updateDate.get();
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate.set(updateDate);
	}
	
	public Double getAmount() {
		return this.amount.get();
	}

	public void setAmount(Double amount) {
		this.amount.set(amount);
	}
}

