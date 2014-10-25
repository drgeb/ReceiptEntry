package com.drgeb.receiptentry.sm;

/**
 *
 * @author Dr. Gerald E. Bennett Following architectural pattern of Jason
 *         Zhicheng Li (jason@lizjason.com)
 */
public interface ReceiptTransitions {
    public void createTRN();

    public void viewTRN();

    public void editTRN();

    public void deleteTRN();

    public void exportTRN();

    public void saveReceiptTRN();

    public void closeReceiptTRN();

    public void deleteReceiptTRN();

    public void exportReceiptsTRN();

}
