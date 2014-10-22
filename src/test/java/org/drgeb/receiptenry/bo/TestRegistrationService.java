package org.drgeb.receiptenry.bo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.drgeb.receiptentry.bo.Receipt;

/**
 *
 * @author adam-bien.com
 */
public class TestRegistrationService {

    private EntityManager em;
    private EntityManagerFactory emf;
    private EntityTransaction et;

    @PostConstruct
    public void init() {
        this.emf = Persistence.createEntityManagerFactory("mioentry");
        this.em = this.emf.createEntityManager();
        this.et = this.em.getTransaction();
    }

    public List<Receipt> all() {
        return this.em.createNamedQuery(Receipt.findAll).getResultList();
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
