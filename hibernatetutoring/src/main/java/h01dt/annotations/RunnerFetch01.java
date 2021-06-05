package h01dt.annotations;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {

	public static void main(String[] args) {
		
		Students01 std1 = new Students01();
		
		Students01 std2 = new Students01();

		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students01.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//1.way
	//	std1 = session.get(Students01.class, 101);
	//	std2 = session.get(Students01.class, 102);
		
		
		
//		System.out.println(std1);
//		System.out.println(std2);
		
		// 2.way 
		
//		String sqlQuery1 = "SELECT * FROM students_table";
//		List <Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//		for(Object[] w:resultList1) {
//			System.out.println(Arrays.toString(w));
//		}
		
		
		//3. way 
//		String hqlQuery = "FROM Students01";
//		List <Object> resultList2 = session.createQuery(hqlQuery).getResultList();
//		
//		for(Object w:resultList2) {
//			System.out.println(w);
//			
//		}
		
		
		//Fetch data by using students name 
		
		//1. sql quert 
		String slqQuery2 = "SELECT * FROM students_table WHERE name='Ali Can'";
//		List <Object []> resultList3 = session.createSQLQuery(slqQuery2).getResultList();

		
//		
//		for(Object[] w:resultList3) {
//			System.out.println(Arrays.toString(w));
//		}
//		
//		Object [] result1 = (Object []) session.createSQLQuery(slqQuery2).uniqueResult();
//		System.out.println(Arrays.toString(result1));
//		
		String hqlQuery2 = "FROM Students01 s WHERE s.name = 'Ali Can'";
//		List <Object> resultList3 = session.createQuery(hqlQuery2).getResultList();
//		for(Object w:resultList3) {
//			System.out.println(w);
//		}
//		
		//For single result we can following
		Object result2 = session.createQuery(hqlQuery2).uniqueResult();
		System.out.println(result2);
		tx.commit();
		
		session.close();
		
	}

}
