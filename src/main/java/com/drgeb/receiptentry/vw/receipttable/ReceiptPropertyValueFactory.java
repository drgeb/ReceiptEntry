package com.drgeb.receiptentry.vw.receipttable;

/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *

 */

import javafx.beans.NamedArg;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.ReceiptWOContext;
import com.sun.javafx.property.PropertyReference;

public class ReceiptPropertyValueFactory<S, T> implements
	Callback<CellDataFeatures<S, T>, ObservableValue<T>> {

    private final static Logger log = LoggerFactory.getLogger(ReceiptWOContext.class);
    
    private final String property;

    private Class<Receipt> columnClass;
    private String previousProperty;
    private PropertyReference<T> propertyRef;

    /**
     * Creates a default ReceiptPropertyValueFactory to extract the value from a
     * given TableView row item reflectively, using the given property name.
     *
     * @param property
     *            The name of the property with which to attempt to reflectively
     *            extract a corresponding value for in a given object.
     */
    public ReceiptPropertyValueFactory(@NamedArg("property") String property) {
	this.property = property;
    }

    /** {@inheritDoc} */
    @Override
    public ObservableValue<T> call(CellDataFeatures<S, T> param) {
	return getCellDataReflectively(param.getValue());
    }

    /**
     * Returns the property name provided in the constructor.
     */
    public final String getProperty() {
	return property;
    }

    private ObservableValue<T> getCellDataReflectively(S rowData) {
	if (getProperty() == null || getProperty().isEmpty() || rowData == null)
	    return null;

	try {
	    // we attempt to cache the property reference here, as otherwise
	    // performance suffers when working in large data models. For
	    // a bit of reference, refer to RT-13937.
	    ReceiptWO rrwo = (ReceiptWO) rowData;
	    Receipt r = rrwo.getReceipt();
	    if (columnClass == null || previousProperty == null
		    || !columnClass.equals(rowData.getClass())
		    || !previousProperty.equals(getProperty())) {

		// create a new PropertyReference
		this.columnClass = (Class<Receipt>) r.getClass();
		this.previousProperty = getProperty();
		this.propertyRef = new PropertyReference<T>(r.getClass(),
			getProperty());
	    }

	    T value = propertyRef.get(r);
	    return new ReadOnlyObjectWrapper<T>(value);

	} catch (IllegalStateException e) {
	    // log the warning and move on
		log.error("Can not retrieve property '" + getProperty()
			+ "' in ReceiptPropertyValueFactory: " + this
			+ " with provided class type: " + rowData.getClass(), e);
	}

	return null;
    }
}
