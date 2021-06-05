package h07.lazyfetch_eagerfetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
	
	public static void main(String[] args) {

	Students07 s1 = new Students07();
	
	Configuration con = new Configuration().
			configure("hibernate12.cfg.xml").
			addAnnotatedClass(Students07.class).
			addAnnotatedClass(Books07.class);
	
	SessionFactory  sf = con.buildSessionFactory();
	
	Session session = sf.openSession();
	
	Transaction tx = session.beginTransaction();
	
	s1 = session.get(Students07.class,1001);
	System.out.println(s1);

	
	session.save(s1);
	
	tx.commit();
	sf.close();
	session.close();

	}
}

