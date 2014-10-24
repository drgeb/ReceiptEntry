package com.drgeb.receiptentry.sm;

import com.drgeb.receiptentry.impl.ReceiptWOFactoryImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/** 
 * A test case for the state transitions of the 
 * Receipt object. 
 * @author Dr. Gerald E. Bennett (developer@drgeb.com)
 */
public class SMCTestCase extends TestCase {
	public SMCTestCase(String name) {
		super(name);
	}
	
	public void testStateTransitions() throws Exception {
		
		ReceiptWOFactory ReceiptWOFactory = 
			new ReceiptWOFactoryImpl();
		/*
		ReceiptWO ReceiptWO = 
			ReceiptWOFactory.createReceiptWO(null);
		
		//initial state: created.
		assertEquals(ReceiptState.CreateState,  ReceiptWO.getReceipt().getState());
		//trigger the view transtion , it should be still in created state
		ReceiptWO.viewAction();
		assertEquals(ReceiptState.ViewState,  ReceiptWO.getReceipt().getState());		
		*/
	}		
}
