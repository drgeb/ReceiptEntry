package com.drgeb.receiptentry.sm;

/**
 * The state machine wrapper. This class can be generated using, for example,
 * XDoclet, based on the generated <code>ReceiptWOContext</code>.
 * 
 * This main purpose of this class is to synchronize the state machine internal
 * state to the state of the business object
 *
 * @author Jason Zhicheng Li (jason@lizjason.com)
 */
public class ReceiptWOContextWrapper implements ReceiptTransitions {
	private ReceiptWOContext receiptContext;

	public ReceiptWOContextWrapper(ReceiptWO owner) {
		receiptContext = new ReceiptWOContext(owner);
		synchronizeState(owner);
	}

	private void synchronizeState(ReceiptWO owner) {
		ReceiptState state = owner.getReceipt().getState();
		switch (state) {
		case TABLEVIEW:
			receiptContext.setState(ReceiptWOContext.ReceiptEntryMap.TABLEVIEW);
			break;
		case CreateState:
			receiptContext.setState(ReceiptWOContext.ReceiptEntryMap.CreateState);
			break;
		case ViewState:
			receiptContext.setState(ReceiptWOContext.ReceiptEntryMap.ViewState);
			break;
		case EditState:
			receiptContext.setState(ReceiptWOContext.ReceiptEntryMap.EditState);
			break;
		case DeleteState:
			receiptContext.setState(ReceiptWOContext.ReceiptEntryMap.DeleteState);
			break;
		case ExportState:
			receiptContext.setState(ReceiptWOContext.ReceiptEntryMap.ExportState);
			break;
		default:
			throw new IllegalArgumentException("Unsupported receipt state:"
					+ state);
		}
	}
	
	//DEFINE TRANSITIONS
	public void saveReceiptTRN() {
		receiptContext.saveReceiptTRN();
	}

	public void closeReceiptTRN() {
		receiptContext.closeReceiptTRN();
	}

	public void deleteReceiptTRN() {
		receiptContext.deleteReceiptTRN();
	}

	public void exportReceiptsTRN() {
		receiptContext.exportReceiptsTRN();
	}

	@Override
	public void createTRN() {
	    receiptContext.createTRN();
	}

	@Override
	public void viewTRN() {
	    receiptContext.viewTRN();
	}

	@Override
	public void editTRN() {
	    receiptContext.editTRN();
	}

	@Override
	public void deleteTRN() {
	    receiptContext.deleteTRN();
	}

	@Override
	public void exportTRN() {
	    receiptContext.exportTRN();
	}

}
