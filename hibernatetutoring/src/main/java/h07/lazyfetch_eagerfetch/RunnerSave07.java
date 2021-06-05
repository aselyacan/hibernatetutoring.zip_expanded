package h07.lazyfetch_eagerfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave07 {

	public static void main(String[] args) {
		
		Books07 b1 = new Books07();
		Books07 b2 = new Books07();
		Books07 b3 = new Books07();
		
		Students07 s1 = new Students07();
		
		s1.setId(1001);
		s1.setName("Ali Can");
		s1.setGrade(11);
		
		b1.setId(101);
		b1.setBook_name("Art Book");
		b1.setStudent(s1);
		
		b2.setId(102);
		b2.setBook_name("Math Book");
		b2.setStudent(s1);
		
		b3.setId(103);
		b3.setBook_name("Science Book");
		b3.setStudent(s1);
		
		s1.getBooksList().add(b1);
		s1.getBooksList().add(b2);
		s1.getBooksList().add(b3);
		
		Configuration con = new Configuration().
				configure("hibernate12.cfg.xml").
				addAnnotatedClass(Students07.class).
				addAnnotatedClass(Books07.class);
		
		SessionFactory  sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(s1);
		session.save(b1);
		session.save(b2);
		session.save(b3);
	
		
		tx.commit();
		sf.close();
		session.close();

	}

}
