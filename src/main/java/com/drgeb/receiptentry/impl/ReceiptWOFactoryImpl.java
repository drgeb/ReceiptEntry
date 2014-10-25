package com.drgeb.receiptentry.impl;

/**
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/
import com.drgeb.receiptentry.action.CloseReceiptAction;
import com.drgeb.receiptentry.action.CreateReceiptAction;
import com.drgeb.receiptentry.action.DeleteReceiptAction;
import com.drgeb.receiptentry.action.EditReceiptAction;
import com.drgeb.receiptentry.action.ExportReceiptAction;
import com.drgeb.receiptentry.action.SaveReceiptAction;
import com.drgeb.receiptentry.action.SyncStateAction;
import com.drgeb.receiptentry.action.ViewReceiptAction;
import com.drgeb.receiptentry.action.impl.CloseReceiptActionImpl;
import com.drgeb.receiptentry.action.impl.CreateReceiptActionImpl;
import com.drgeb.receiptentry.action.impl.DeleteReceiptActionImpl;
import com.drgeb.receiptentry.action.impl.EditReceiptActionImpl;
import com.drgeb.receiptentry.action.impl.ExportReceiptActionImpl;
import com.drgeb.receiptentry.action.impl.SaveReceiptActionImpl;
import com.drgeb.receiptentry.action.impl.SyncStateActionImpl;
import com.drgeb.receiptentry.action.impl.ViewReceiptActionImpl;
import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.sm.ReceiptActions;
import com.drgeb.receiptentry.sm.ReceiptConditions;
import com.drgeb.receiptentry.sm.ReceiptState;
import com.drgeb.receiptentry.sm.ReceiptTransitions;
import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.ReceiptWOContextWrapper;
import com.drgeb.receiptentry.sm.ReceiptWOFactory;
import com.drgeb.receiptentry.impl.ReceiptActionsImpl;


/**
 * Factory class for the <code>ReceiptWO</code> classes. It hides the details
 * that how the ReceiptWO instances are created.
 * 
 * @author Jason Zhicheng Li (jason@lizjason.com)
 */
public class ReceiptWOFactoryImpl implements ReceiptWOFactory {

    public ReceiptWO createReceiptWO(String receiptId) {
	// the receipt object should be retrieved from database
	// or create a new one if the receipt id is null.
	// create a dummy receipt object here.
	Receipt receipt = null;
	if (receiptId == null) {
	    receipt = new Receipt();
	    receipt.setState(ReceiptState.TABLEVIEW);
	} else {
	    receipt.setReceiptId(receiptId);
	}

	// the worker object
	ReceiptWOImpl receiptWO = new ReceiptWOImpl();
	receiptWO.setReceipt(receipt);

	// set up actions. Typically it is wired up via dependency injection
	ReceiptActions receiptActions = this.createReceiptActions();
	receiptWO.setReceiptActions(receiptActions);

	// conditions
	ReceiptConditions receiptConditions = createReceiptConditions();
	receiptWO.setReceiptConditions(receiptConditions);

	// the state machine and its wrapper
	// note that the state machine internal state
	// will be sync with the state of the receipt object.
	ReceiptTransitions receiptTransitions = new ReceiptWOContextWrapper(receiptWO);
	receiptWO.setReceiptTransitions(receiptTransitions);

	return receiptWO;
    }

    private ReceiptActions createReceiptActions() {
	//Note receiptActions is assigned to ReceiptActionsImpl class so we can set the 
	//syncStateAction method, cause this method is not part 
	//of ReceiptActions interface.
	ReceiptActionsImpl receiptActions = new ReceiptActionsImpl();

	CloseReceiptAction closeReceiptAction = new CloseReceiptActionImpl();
	CreateReceiptAction createReceiptAction = new CreateReceiptActionImpl();
	DeleteReceiptAction deleteReceiptAction = new DeleteReceiptActionImpl();
	EditReceiptAction editReceiptAction = new EditReceiptActionImpl();
	ExportReceiptAction exportReceiptAction = new ExportReceiptActionImpl();
	SaveReceiptAction saveReceiptAction = new SaveReceiptActionImpl();
	ViewReceiptAction viewReceiptAction = new ViewReceiptActionImpl();
	SyncStateAction syncStateAction =
		new SyncStateActionImpl();
	
	receiptActions.setCreateReceiptAction(createReceiptAction);
	receiptActions.setDeleteReceiptAction(deleteReceiptAction);
	receiptActions.setEditReceiptAction(editReceiptAction);
	receiptActions.setExportReceiptAction(exportReceiptAction);
	receiptActions.setSaveReceiptAction(saveReceiptAction);
	receiptActions.setViewReceiptAction(viewReceiptAction);
	receiptActions.setCloseReceiptAction(closeReceiptAction);
	receiptActions.setSyncStateAction(syncStateAction);
	return receiptActions;
    }

    private ReceiptConditions createReceiptConditions() {
	ReceiptConditionsImpl receiptConditions = new ReceiptConditionsImpl();
	// TODO ADD method implementations
	return receiptConditions;
    }
}
