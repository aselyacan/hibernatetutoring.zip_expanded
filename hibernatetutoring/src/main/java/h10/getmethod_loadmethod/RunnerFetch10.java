package h10.getmethod_loadmethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch10 {

	public static void main(String[] args) {
		
		Students10 student = new Students10();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students10.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		/*
		 	1)If record cannot be found get() returns "null", load() throws "org.hibernate.ObjectNotFoundException"
		 	2)load() method fetches the data if you type any code to use the data but get() fetches data even if you do not use it.
		 	3)get() returns fully initialized object so this method eager load the object but load() always returns proxy object(blank object) 
		      so this method is lazy load the object.
		    4)get() is faster than load() 
		    
		    Note: When do we need to use load()
		    
		    	  If student has data about books, and you need to fetch student record but you will not use book details for the student.
		    	  We use load() to assign proxy object to book then we use get method for the student.
		    	  
		    	  But most of the times we use get()...
		     
		 */
		
		//Fetch the record whose id is 1001 by using get()
		student = session.get(Students10.class, 1001);
		//System.out.println(student);
		
		//Fetch the record whose id is 1001 by using load()
		student = session.load(Students10.class, 1002);
		//System.out.println(student);
		
		tx.commit();

	}

}
