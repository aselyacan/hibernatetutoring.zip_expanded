package h09.hql_queries;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

	public static void main(String[] args) {
		
		Students09 student = new Students09(); 
		
		Configuration con = new Configuration().
				configure("hibernate12.cfg.xml").
				addAnnotatedClass(Students09.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		//We can update data in two ways
		// 1st way : By using HQL queries.
		
		//1)Update the name of the student whose id is 11 to Ali Can
		
//		String hqlQuery1 = "UPDATE Students09 s SET s.name = 'Ali Can' "
//							+ "WHERE s.id= 11";
//		
//		int numOfRec1 = session.createQuery(hqlQuery1).executeUpdate();
//		System.out.println("Number of affected record:" + numOfRec1);
//		
//		// 2st way : By using Session methods .
//		//1)Update the name of the student whose id is 12 to Veli Han
//		
//		student = session.get(Students09.class, 12);
//		student.setName("Veli Han");
//		session.update(student);

		//3)Update the math grades of the students to 100 whose mathGrades are more than 90
//		String hqlQuery2 = "UPDATE Students09 s SET s.mathGrade = 100 "
//				+ "WHERE s.mathGrade > 90";
//
//		int numOfRec2 = session.createQuery(hqlQuery2).executeUpdate();
//		System.out.println("Number of affected record:" + numOfRec2);
		
		//3)Update the math grades of the students to 50 whose mathGrades are more than 30
		
		for(int i=1; i<=50; i++) {	
			student = session.get(Students09.class, i);
			if (student.getMathGrade()<30) {
				student.setMathGrade(50);
				session.update(student);
			}
		}
		
		//1)Insert a record whose id is 51, name is "Kemal Kuzu", and mathGrade is 97	
	
//		String hqlQuery3 = "INSERT INTO Students09 OPEN (51,97, 'Kemal Kuzu')";
//		session.createQuery(hqlQuery3);  ---NO usage
		
//		2.way
		
		
		

		
		
		tx.commit();
		session.close();
		
	}

}
