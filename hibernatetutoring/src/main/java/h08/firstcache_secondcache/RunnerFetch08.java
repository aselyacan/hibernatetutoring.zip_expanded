package h08.firstcache_secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerFetch08 {

	public static void main(String[] args) {
		
		Books08 book = new Books08();
		Students08 s1 = new Students08();
		
		Configuration con = new Configuration().
				configure("hibernate12.cfg.xml").
				addAnnotatedClass(Students08.class).
				addAnnotatedClass(Books08.class);
		
		SessionFactory  sf = con.buildSessionFactory();
		
		Session session1 = sf.openSession();
		
		Transaction tx1 = session1.beginTransaction();
		
		// 1 st scenario : just once hit the database.
		
//		book = session1.get(Books08.class,101);
//		System.out.println(book);
//		
//		book = session1.get(Books08.class,101);
//		System.out.println(book);
		
		book = session1.get(Books08.class,101);
		System.out.println(book);
//		
//		book = session1.get(Books08.class,102);
//		System.out.println(book);
		
		tx1.commit();
		session1.close();
		
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		book = session2.get(Books08.class,101);
		
		
		tx2.commit();
		
		Session session3 = sf.openSession();
		Transaction tx3 = session3.beginTransaction();
		book = session3.get(Books08.class,102);
		
		Session session4 = sf.openSession();
		Transaction tx4 = session4.beginTransaction();
		book = session4.get(Books08.class,102);
		
		session4.close();
		session3.close();
		session2.close();
		
		
		
		
		
		

		
	}

}
