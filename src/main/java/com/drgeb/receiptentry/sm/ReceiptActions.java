package com.drgeb.receiptentry.sm;
/**
*
* @author Dr. Gerald E. Bennett
* Following architectural pattern of Jason Zhicheng Li (jason@lizjason.com)
*/
public interface ReceiptActions {

    public void createAction();

    public void viewAction();

    public void editAction();

    public void deleteAction();

    public void exportAction();

    public void saveAction();

    public void closeAction();
}
