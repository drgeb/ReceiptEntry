package com.drgeb.receiptentry.sm;


/** 
 * The state machine wrapper. This class can be generated using, for
 * example, XDoclet, based on the generated <code>ReceiptWOContext</code>.
 * 
 * This main purpose of this class is to synchronize the state 
 * machine internal state to the state of the business object 
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
		case Created:
			receiptContext.setState(ReceiptWOContext.MainMap.Created);
			break;
		case Paid:
			receiptContext.setState(ReceiptWOContext.MainMap.CheckingCredit);
			break;
		case Filled:
			receiptContext.setState(ReceiptWOContext.MainMap.Filled);
			break;
		default:
			throw new IllegalArgumentException("Unsupported receipt state:"
					+ state);
		}
	}

	public void view() {
		receiptContext.view();		
	}

	public void submit(String userId, String itemId, int itemCount) {
		receiptContext.submit(userId, itemId,itemCount);
	}

	public void fill() {
		receiptContext.fill();
	}

	public void ship() {
		receiptContext.ship();
	}

	public void reject() {
		receiptContext.reject();
	}
}
