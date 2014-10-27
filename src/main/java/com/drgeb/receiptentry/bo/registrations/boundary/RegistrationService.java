package com.drgeb.receiptentry.bo.registrations.boundary;

/**
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.drgeb.receiptentry.bo.Receipt;
import com.drgeb.receiptentry.sm.ReceiptWO;
import com.drgeb.receiptentry.sm.ReceiptWOFactory;
import com.drgeb.receiptentry.sm.impl.ReceiptWOFactoryImpl;

/**
 *
 * @author Dr. Gerald E. Bennett
 */
public class RegistrationService {

    private EntityManager em;
    private EntityManagerFactory emf;
    private EntityTransaction et;

    @PostConstruct
    public void init() {
	this.emf = Persistence.createEntityManagerFactory("receiptentry");
	this.em = this.emf.createEntityManager();
	this.et = this.em.getTransaction();
    }

    public List<ReceiptWO> all() {
	RegistrationService registrationService = this;
	Query q = registrationService.em.createNamedQuery(Receipt.findAll);
	// TODO transform Query REceipt into ReceiptWO
	List<Receipt> resultReceiptList = q.getResultList();
	List<ReceiptWO> resultList = new ArrayList<ReceiptWO>();
	ReceiptWOFactory receiptWOFactory = new ReceiptWOFactoryImpl();
	for (Receipt receipt : resultReceiptList) {
	    ReceiptWO receiptWO = receiptWOFactory.createReceiptWO(receipt);
	    resultList.add(receiptWO);
	}
	return resultList;
    }

    public Receipt findWithID(String receiptID) {
	List<Receipt> l = em
		.createQuery(
			"SELECT r FROM Receipt r WHERE r.name LIKE :receiptID")
		.setParameter("receiptID", receiptID).getResultList();
	Receipt r = l.get(0);
	return r;
    }

    public Receipt save(Receipt receipt) {
	et.begin();
	Receipt merged = this.em.merge(receipt);
	et.commit();
	return merged;
    }

    public void save() {
	et.begin();
	em.flush();
	et.commit();
    }

    public void remove(Receipt receipt) {
	et.begin();
	this.em.remove(receipt);
	et.commit();
    }

    public void close() {
	et.begin();
	et.commit();
	em.close();
    }
}
