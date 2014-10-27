package com.drgeb.receiptentry.sm;

import com.drgeb.receiptentry.sm.impl.ReceiptWOFactoryImpl;

import junit.framework.TestCase;

/**
 * A test case for the state transitions of the Receipt object.
 * 
 * @author Dr. Gerald E. Bennett (developer@drgeb.com)
 */
public class SMCTestCase extends TestCase {
    public SMCTestCase(String name) {
	super(name);
    }

    public void testStateTransitions() throws Exception {

	ReceiptWOFactory receiptWOFactory = new ReceiptWOFactoryImpl();
	String id=null;
	ReceiptWO receiptWO = receiptWOFactory.createReceiptWO(id);
	// initial state: created.
	assertEquals(ReceiptState.TABLEVIEW, receiptWO.getReceipt().getState());
	
	//receiptWO.editAction(receiptWO.getReceipt());
	// trigger the view transition , it should be still in created state
	//OK receiptWO.createTRN();
	//OK receiptWO.viewTRN();
	//OK receiptWO.editTRN();
	//OK receiptWO.deleteTRN();
	//OK receiptWO.exportTRN();
	//receiptWO.saveReceiptTRN();
	//receiptWO.closeReceiptTRN();
	//receiptWO.deleteReceiptTRN();
	//Failed receiptWO.exportReceiptsTRN();
	
	// receiptWO.viewAction(receiptWO.getReceipt());
	System.out.println("State:" + receiptWO.getReceipt().getState());
	// assertEquals(ReceiptState.ViewState,
	// receiptWO.getReceipt().getState());
    }
}
