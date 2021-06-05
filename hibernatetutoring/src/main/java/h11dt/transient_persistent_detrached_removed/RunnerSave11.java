package h11dt.transient_persistent_detrached_removed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students11.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		/*
		 Transient Object: If you create an object in Java but you do not associate with Hibernate Session, 
		                   the object is called transient object
		*/
		Students11 student = new Students11();
		student.setId(101);
		student.setName("Ali Can");
		student.setMathGrade(97);
		
		/*
		 Persistent Object: If you associate an object with a session, then it is called "Persistent Object"
		*/
		session.save(student);
		
		
		
		tx.commit();
		/*
		 Detached Object: If you close the session which is associated with an object, then
		                  the object is called "Detached Object"
		*/
		session.close();
		student.setName("Veli Han");
		
		Session session2 = sf.openSession();
		
		Transaction tx2 = session2.beginTransaction();
		
		Students11 student2 = new Students11();
		student2.setId(102);
		student2.setName("Ayse Can");
		student2.setMathGrade(85);
		
		session2.save(student2);
		
		/*
		 Removed Object: If you delete a record from DB by using delete() or remove() or HQL Query
		                 then the object is called "Removed Object"
		                 Note: Removed Objects exist in Java, do not exist in Database
		                 Note: Garbage Collector may destroy Transient, Detache, and Removed objects
		*/
		session2.delete(student2);
		
		
		tx2.commit();

	}

}
