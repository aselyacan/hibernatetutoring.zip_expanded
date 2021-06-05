package h01dt.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

	public static void main(String[] args) {
		
		Students01 std1 = new Students01();
		std1.setId(101);
		std1.setGrade(11);
		std1.setName("Ali Can");
		
		Students01 std2 = new Students01();
		std2.setId(102);
		std2.setGrade(11);
		std2.setName("Veli Han");
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students01.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(std1);
		session.save(std2);
		
		tx.commit();
		
		session.close();

	}

}