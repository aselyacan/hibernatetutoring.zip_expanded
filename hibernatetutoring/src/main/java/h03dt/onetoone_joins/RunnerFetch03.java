package h03dt.onetoone_joins;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerFetch03 {

	public static void main(String[] args) {
		
		Students03 std1 = new Students03();
		Diary d1 = new Diary();
	
		Configuration con = new Configuration().
				configure("hibernate12.cfg.xml").
				addAnnotatedClass(Students03.class).
				addAnnotatedClass(Diary.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Fetch the students whose id is 101 by using get()
		std1 = session.get(Students03.class, 101);
		System.out.println("-----------------------------------------------------");
		System.out.println(std1);
		
		// Fetch the diary details of a students whose id is 101 by using get()
		d1 = session.get(Diary.class, 11);
		System.out.println(d1);
		
		// Fetch the common records from  Students and  Diary tables.
		// 1.way : By using SQL Queries.
		
//		String sqlQuery1 = "SELECT s.std_name, d.diaryname, s.grade\n"
//				+ "FROM students03 s\n"
//				+ "INNER JOIN diary d ON s.std_id = d.student_id";
//				
//		List <Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//		for(Object[] w:resultList1) {
//			System.out.println(Arrays.toString(w));
//		}
//	
//		String hqlQuery1 = "FROM Students03 s INNER JOIN FETCH s.diary";
//			
//		List <Object> resultList2 = session.createQuery(hqlQuery1).getResultList();
//		for(Object w:resultList2) {
//			System.out.println(w);
//		}
//		
//		String hqlQuery2 = "FROM Diary d INNER JOIN FETCH d.student";
//		
//		List <Object> resultList3 = session.createQuery(hqlQuery2).getResultList();
//		for(Object w:resultList3) {
//			System.out.println(w);
//		}
		
		
//		String hqlQuery3 = "FROM Diary d LEFT JOIN FETCH d.student";
//		
//		List <Object> resultList4 = session.createQuery(hqlQuery3).getResultList();
//		for(Object w:resultList4) {
//			System.out.println(w);
//		}
		

//		String hqlQuery4 = "FROM Diary d RIGHT JOIN FETCH d.student";
//		
//		List <Object> resultList5 = session.createQuery(hqlQuery4).getResultList();
//		for(Object w:resultList5) {
//			System.out.println(w);
//		}
		
//		String sqlQuery2 = "SELECT s.std_name, s.grade, d.diaryName "
//							+ "FROM Students03 s "
//							+ "FULL JOIN FETCH Diary d ON s.std_id = d.student_id";	
//		
//		List <Object []> resultList6 = session.createSQLQuery(sqlQuery2).getResultList();
//		for(Object [] w:resultList6){
//			System.out.println(Arrays.toString(w));
//			
//		}
		
		String hqlQuery5 = "SELECT s.name, s.grade, d.diaryName "
				+ "FROM Students03 s "
				+ "LEFT JOIN FETCH Diary d ON s.std_id = d.student";	
		
		List <Object []> resultList7 = session.createQuery(hqlQuery5).getResultList();
		for(Object[] w:resultList7){
			System.out.println(Arrays.toString(w));
			
		}
		tx.commit();
	
		session.close();
		sf.close();
	}

}
