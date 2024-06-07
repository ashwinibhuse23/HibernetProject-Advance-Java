package main.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.Transaction;

import entertainment.entity.annotations.Movie;
import utils.HibernateUtils;

public class RecordInsertionExampleMain {

	public static void main(String[] args) {
		try(
			SessionFactory sf=HibernateUtils.getSessionFactory();
			Session sessionRef=sf.openSession();
				){
			Movie movieObj=new Movie(103,"Runway 34","Thriller",2022);
			Transaction tx=sessionRef.beginTransaction();
			
			sessionRef.persist(movieObj);
			tx.commit();
			System.out.println("Record inserted..");
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
