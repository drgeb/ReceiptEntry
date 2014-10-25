package com.drgeb.receiptentry.sm;
/**
*
* @author Dr. Gerald E. Bennett
* Following architectural pattern of Jason Zhicheng Li (jason@lizjason.com)
*/
import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.sm.ReceiptConditions;
import com.drgeb.receiptentry.sm.ReceiptTransitions;

/** 
 * The wrapper object ( or working object) to
 * serve business service requests for the
 * Order object. The business service layer delegates
 * service requests to this object via the transition
 * interface. 
 * 
 * Note that the condition and action interfaces should not
 * be exposured to the outside, but, for simplicity, in this example,
 * working object also implements both the <code>
 * OrderConditions</code> and <code>OrderActions</code>
 * interfaces.
 * @author Jason Zhicheng Li (jason@lizjason.com)
 */

public interface ReceiptWO extends ReceiptTransitions, 
ReceiptConditions, ReceiptActions{
	/**  
	 * @return underlying POJO order object.
	 */
	Receipt getReceipt();
	
	/**
	 * Sets a new target business object for the 
	 * wrapper object
	 * @param order the new business object
	 */
	void setReceipt(Receipt receipt);
	
}
