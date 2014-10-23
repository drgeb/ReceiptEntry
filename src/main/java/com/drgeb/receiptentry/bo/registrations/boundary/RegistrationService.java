package com.drgeb.receiptentry.bo.registrations.boundary;

/**
*
* @author Dr. Gerald E. Bennett
* 
**/
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.drgeb.receiptentry.bo.Receipt;

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

    public List<Receipt> all() {
        RegistrationService registrationService = this;
        Query q=registrationService.em.createNamedQuery(Receipt.findAll);
		List<Receipt> resultList = q.getResultList();
		return resultList;
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
