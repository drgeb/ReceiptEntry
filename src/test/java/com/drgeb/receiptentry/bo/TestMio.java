/**
 * 
 */
package com.drgeb.receiptentry.bo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.drgeb.receiptentry.bo.Mio;

/**
 * @author drgeb
 *
 */
public class TestMio extends TestCase {

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
		} catch (Exception ex) {
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
		Mio mio = new Mio();
		
		mio.setAuthor("Gerry Bennett");
		mio.setVendor("Vendor 1");
		mio.setUpdateDate(LocalDate.now());
		mio.setPurchaseDate(LocalDate.now());
		List<Mio> list = this.em.createNamedQuery(Mio.findAll).getResultList();
		int before = list.size();

		et.begin();
		Mio merged = this.em.merge(mio);
		et.commit();

		list = this.em.createNamedQuery(Mio.findAll).getResultList();
		int after = list.size();

		assertEquals("Expected after to be equal to before plus one", after,
				before + 1);
		System.out.println("Size:" + after);
	}
}
