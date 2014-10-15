package com.drgeb.receiptentry.bo;

import java.util.Date;
import java.util.UUID;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.drgeb.receiptentry.sm.ReceiptState;

@Entity
@NamedQueries({
    @NamedQuery(name = Receipt.findAll, query = "SELECT a from Receipt a")
})
public class Receipt {
	
	private static final long serialVersionUID = 1;
    public final static String PREFIX = "com.airhacks.control.business.registrations.entity.Attendee.";
    public final static String findAll = PREFIX + "findAll";

	private StringProperty receiptId;
	private ObjectProperty <ReceiptState> state;	
	private StringProperty vendor;
	private ObjectProperty <Date> purchaseDate;
	private ObjectProperty <Date> entryDate;
	private StringProperty author;
	
	public Receipt(){
		this.receiptId=new SimpleStringProperty(UUID.randomUUID().toString());
		this.state=new SimpleObjectProperty<ReceiptState>();
		this.vendor=new SimpleStringProperty();
		this.purchaseDate=new SimpleObjectProperty<Date>();
		this.entryDate=new SimpleObjectProperty<Date>();
		this.author=new SimpleStringProperty();
				
	}

	@Id
	public String getReceiptId() {
		return receiptId.get();
	}
	public void setReceiptId(String receiptId) {
		this.receiptId .set(receiptId);
	}

	public ReceiptState getState() {
		return (ReceiptState) this.state.getValue();
	}
	
	public void setState(ReceiptState state) {
		this.state.setValue(state);
	}
	public String getVendor() {
		return vendor.get();
	}
	public void setVendor(String vendor) {
		this.vendor.set(vendor);
	}
	public Date getPurchaseDate() {
		return (Date) purchaseDate.getBean();
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate.setValue(purchaseDate);
	}
	public Date getEntryDate() {
		return (Date) entryDate.getBean();
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate.setValue(entryDate);
	}
	public String getAuthor() {
		return this.author.get();
	}
	public void setAuthor(String author) {
		this.author.set(author);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
