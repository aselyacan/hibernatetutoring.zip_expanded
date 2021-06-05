package h05.myhomework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

	public static void main(String[] args) {
		Questions q1 = new Questions();
		Questions q2 = new Questions();
		
		Answers ans1 = new Answers();
		Answers ans2 = new Answers();
		Answers ans3 = new Answers();
		Answers ans4 = new Answers();
		Answers ans5 = new Answers();
		
		ans1.setAns_id(1001);
		ans1.setAnswerBody("Java is an OOP language");
		ans1.setQuestion(q1);
		
		ans2.setAns_id(1002);
		ans2.setAnswerBody("Java is an island of Indonesia");
		ans2.setQuestion(q1);
		
		ans3.setAns_id(1003);
		ans3.setAnswerBody("Java is a general-purpose progamming language");
		ans3.setQuestion(q1);
		
		q1.getAnswersList().add(ans1);
		q1.getAnswersList().add(ans2);
		q1.getAnswersList().add(ans3);
		
		q1.setId(101);
		q1.setQuestionBody("What is Java");
		q1.setAnswersList(q1.getAnswersList());
		
		ans4.setAns_id(1004);
		ans4.setAnswerBody("Containerization are a form of operating system virtualization.");
		ans4.setQuestion(q2);
		
		ans5.setAns_id(1005);
		ans5.setAnswerBody("Containerization is the international shipping practice of storing a number of pieces of freight within a large container");
		ans5.setQuestion(q2);
		
		q2.getAnswersList().add(ans4);
		q2.getAnswersList().add(ans5);
		
		q2.setId(102);
		q2.setQuestionBody("What is Containerization");
		q2.setAnswersList(q2.getAnswersList());
		
		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Questions.class).
				addAnnotatedClass(Answers.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		session.save(q2);
		
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		session.save(ans4);
		session.save(ans5);
	
		tx.commit();
		
		sf.close();
		session.close();
		

	}

}
