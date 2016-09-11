package com.jorge.client;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jorge.entity.Customer;
import com.jorge.entity.Passport;
import com.jorge.util.HibernateUtil;

/**
 * This is a ONE TO ONE bidirectional relationship
 * 
 */

public class Main {

	public static void main(String[] args) {
		BasicConfigurator.configure(); // Necessary for configure log4j. It must be the first line in main method
								       // log4j.properties must be in /src directory
		
		Logger  logger = Logger.getLogger(Main.class.getName());
		logger.debug("log4j configured correctly and logger set");

		logger.debug("getting session factory from HibernateUtil.java");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.getTransaction();
		
		try {
			
			logger.debug("beginning persist transaction");
			txn.begin(); 

			logger.debug("setting data in Passport object");
			Passport passport = new Passport("123345987");
			
			logger.debug("setting data in Customer object");
			Customer customer = new Customer("Homer Simpson", passport);
			
			logger.debug("persisting data");
			session.persist(customer);
		
			logger.debug("making commit");
			txn.commit();
			
		} catch (Exception e) {
			if (txn != null) {
				logger.error("something was wrong, making rollback of transactions");
				txn.rollback(); // If something was wrong, we make rollback
			}
			logger.error("Exception: " + e.getMessage().toString());
		} finally {
			if (session != null) {
				logger.debug("close session");
				session.close();
			}
		}
	}

}
