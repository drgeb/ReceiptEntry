/**
 * 
 */
package org.drgeb.receiptenry.bo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author drgeb
 *
 */
public class TestReceipt {

	@PersistenceContext
	EntityManagerFactory emf;
	EntityManager em;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		try {
		this.emf = Persistence.createEntityManagerFactory("receiptentry");
        this.em = this.emf.createEntityManager();
		} catch (Exception ex)
		{
			System.err.println(ex);
			throw ex;
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
        this.em.close();
        this.emf.close();
	}

	@Test
	public void test() {
		System.out.println("Already to Start Test");
        EntityTransaction et = this.em.getTransaction();
        System.out.println(et.toString());
	}
}
