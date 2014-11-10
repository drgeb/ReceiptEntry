package com.drgeb.receiptentry.bo;

/**
 *
 * @author Dr. Gerald E. Bennett
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.drgeb.receiptentry.sm.ReceiptState;

@Entity
@NamedQueries({ @NamedQuery(name = Receipt.findAll, query = "SELECT a from Receipt a") })
public class Receipt {

    public final static String PREFIX = "com.drgeb.receiptentry.bo.Receipt.";
    public final static String findAll = PREFIX + "findAll";
    public final static String find = PREFIX + "find";

    private StringProperty receiptId;
    private StringProperty vendorProperty;
    private StringProperty author;
    private ObjectProperty<ReceiptState> state;
    private ObjectProperty<LocalDate> purchasedDate;
    private ObjectProperty<LocalDateTime> createDate;
    private ObjectProperty<LocalDateTime> updateDate;
    private DoubleProperty amount;
    private DoubleProperty salesTax;
    private StringProperty currency;
    private StringProperty paymentType;
    private StringProperty location;
    private BooleanProperty reimbursable;
    private BooleanProperty paid;
    private BooleanProperty reconciled;
    private StringProperty notes;

    public Receipt() {
	this.receiptId = new SimpleStringProperty(UUID.randomUUID().toString());
	this.vendorProperty = new SimpleStringProperty();
	this.createDate = new SimpleObjectProperty<LocalDateTime>(
		LocalDateTime.now());
	this.updateDate = new SimpleObjectProperty<LocalDateTime>(
		LocalDateTime.now());
	this.purchasedDate = new SimpleObjectProperty<LocalDate>();
	this.amount = new SimpleDoubleProperty();
	this.salesTax = new SimpleDoubleProperty();
	this.currency = new SimpleStringProperty();
	this.paymentType = new SimpleStringProperty();
	this.location = new SimpleStringProperty();
	this.reimbursable = new SimpleBooleanProperty();
	this.paid = new SimpleBooleanProperty();
	this.reconciled = new SimpleBooleanProperty();

	this.author = new SimpleStringProperty();
	this.state = new SimpleObjectProperty<ReceiptState>();
	this.notes = new SimpleStringProperty();
    }

    /**
     * @return the salesTax
     */
    public double getSalesTax() {
	return this.salesTax.get();
    }

    /**
     * @param salesTax
     *            the salesTax to set
     */
    public void setSalesTax(double salesTax) {
	this.salesTax.set(salesTax);
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
	return this.currency.get();
    }

    /**
     * @param currency
     *            the currency to set
     */
    public void setCurrency(String currency) {
	this.currency.set(currency);
    }

    /**
     * @return the paymentType
     */
    public String getPaymentType() {
	return this.paymentType.get();
    }

    /**
     * @param paymentType
     *            the paymentType to set
     */
    public void setPaymentType(String paymentType) {
	this.paymentType.set(paymentType);
    }

    /**
     * @return the location
     */
    public String getLocation() {
	return this.location.get();
    }

    /**
     * @param string
     *            the location to set
     */
    public void setLocation(String location) {
	this.location.set(location);
    }

    /**
     * @return the reimbursable
     */
    public boolean getReimbursable() {
	return this.reimbursable.get();
    }

    /**
     * @param reimbursable
     *            the reimbursable to set
     */
    public void setReimbursable(boolean reimbursable) {
	this.reimbursable.set(reimbursable);
    }

    /**
     * @return the paid
     */
    public boolean getPaid() {
	return this.paid.get();
    }

    /**
     * @param paid
     *            the paid to set
     */
    public void setPaid(boolean paid) {
	this.paid.set(paid);
    }

    /**
     * @return the reconciled
     */
    public boolean getReconciled() {
	return this.reconciled.get();
    }

    /**
     * @param reconciled
     *            the reconciled to set
     */
    public void setReconciled(boolean reconciled) {
	this.reconciled.set(reconciled);
    }

    public void setAmount(DoubleProperty amount) {
	this.amount = amount;
    }

    @Id
    public String getReceiptId() {
	return receiptId.get();
    }

    public void setReceiptId(String id) {
	this.receiptId.set(id);
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
	return this.vendorProperty.get();
    }

    /**
     * @param vendor
     *            the vendor to set
     */
    public void setVendor(String vendor) {
	this.vendorProperty.set(vendor);
    }

    public String getAuthor() {
	return this.author.get();
    }

    /**
     * @param author
     *            the author to set
     */
    public void setAuthor(String author) {
	this.author.set(author);
    }

    public ReceiptState getState() {
	return (ReceiptState) this.state.get();
    }

    public void setState(ReceiptState state) {
	this.state.set(state);
    }

    /**
     * @return the purchasedDate
     */
    public LocalDate getPurchaseDate() {
	return this.purchasedDate.get();
    }

    /**
     * @param purchasedDate
     *            the purchasedDate to set
     */
    public void setPurchaseDate(LocalDate purchaseDate) {
	this.purchasedDate.set(purchaseDate);
    }

    public LocalDateTime getCreateDate() {
	return this.createDate.get();
    }

    /**
     * @param createDate
     *            the createDate to set
     */
    public void setCreateDate(LocalDateTime createDate) {
	this.createDate.set(createDate);
    }

    public LocalDateTime getUpdateDate() {
	return this.updateDate.get();
    }

    public void setUpdateDate(LocalDateTime updateDate) {
	this.updateDate.set(updateDate);
    }

    public Double getAmount() {
	return this.amount.get();
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(Double amount) {
	this.amount.set(amount);
    }

    /**
     * @return the notes
     */
    public String getNotes() {
	return this.notes.get();
    }

    /**
     * @param notes
     *            the notes to set
     */
    public void setNotes(String notes) {
	this.notes.set(notes);
    }
}
