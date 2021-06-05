package h05.myhomework;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {

	public static void main(String[] args) {
		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Questions.class).
				addAnnotatedClass(Answers.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		String hqlQuery1 = "SELECT q.id, q.questionBody, a.answerBody "
				+ "FROM Questions q FULL JOIN FETCH Answers a "
				+ "ON q.id = a.question";
		
		List <Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
		
		for(Object[] w: resultList1) {
			System.out.println(Arrays.toString(w));
		}
		
		
		tx.commit();
		sf.close();
		session.close();
		

	}

}
