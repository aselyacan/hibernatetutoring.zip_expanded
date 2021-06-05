package h04.onetomany_joins;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import h03dt.onetoone_joins.Diary;
import h03dt.onetoone_joins.Students03;

public class RunnerFetch04 {

	public static void main(String[] args) {
		
		Students04 student = new Students04();
		
		Books04 book = new Books04();
		
		Configuration con = new Configuration().
				configure("hibernate12.cfg.xml").
				addAnnotatedClass(Students04.class).
				addAnnotatedClass(Books04.class);
		
		SessionFactory  sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Example 1: Fetch all books of a student whose id is 1001 by using get() method
		
//		student = session.get(Students04.class, 1001);
//		for(Books04 w: student.getBooksList()) {
//			System.out.println(w);
//		}
		
		
		// Example 2: Fetch the owner of a  book whose id is 101 by using get() method
//		book = session.get(Books04.class, 101);
//		student = session.get(Students04.class, book.getStudent().getStd_id());
//		System.out.println(student);
		
		
		// Example 3: Fetch the student name o f common records from Studetns04 and Books04 
//		String sqlQuery1 = "SELECT s.name, b.book_name\n"
//				+ "FROM students04 s INNER JOIN books04 b \n"
//				+ "ON s.std_id = b.student_id";
//		
//		List <Object []> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//		for(Object [] w: resultList1) {
//			System.out.println(Arrays.toString(w));
//		}
	
//		String hqlQuery1 = "SELECT s.name, b.book_name\n"
//							+ "FROM Students04 s INNER JOIN FETCH Books04 b \n"
//							+ "ON s.std_id = b.student";
//		
//		List <Object[]> resultList2 = session.createQuery(hqlQuery1).getResultList();
//		for(Object[] w: resultList2) {
//			System.out.println(Arrays.toString(w));
//		}
		
		// Example 3: Fetch the student name o f common records from Studetns04 and Books04 
//		String sqlQuery2 = "SELECT s.name, b.book_name, b.book_id\n"
//				+ "FROM students04 s LEFT JOIN books04 b \n"
//				+ "ON s.std_id = b.student_id";
//		
//		List <Object []> resultList3 = session.createSQLQuery(sqlQuery2).getResultList();
//		for(Object [] w: resultList3) {
//			System.out.println(Arrays.toString(w));
//		}
		

//		String hqlQuery2 = "SELECT s.name, b.book_name, b.book_id\n"
//				+ "FROM Students04 s LEFT JOIN FETCH Books04 b \n"
//				+ "ON s.std_id = b.student";
//		
//		//  HQL IS CASE SENSITIVE
//		List <Object []> resultList4 = session.createQuery(hqlQuery2).getResultList();
//		for(Object [] w: resultList4) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//Example 5: Fetch student name, book name of records from Books04 table (RIGHT JOIN)
//				String sqlQuery3 = "SELECT s.name, b.book_name, b.book_id\n"
//				+ "FROM students04 s RIGHT JOIN books04 b \n"
//				+ "ON s.std_id = b.student_id";
//		
//		List <Object []> resultList4 = session.createSQLQuery(sqlQuery3).getResultList();
//		for(Object [] w: resultList4) {
//			System.out.println(Arrays.toString(w));
//		}
		

//		String hqlQuery3 = "SELECT s.name, b.book_name, b.book_id\n"
//				+ "FROM Students04 s RIGHT JOIN FETCH Books04 b \n"
//				+ "ON s.std_id = b.student";
//		
//		//  HQL IS CASE SENSITIVE
//		List <Object []> resultList5 = session.createQuery(hqlQuery3).getResultList();
//		for(Object [] w: resultList5) {
//			System.out.println(Arrays.toString(w));
//		}
		
		
//		String sqlQuery4 = "SELECT s.name, b.book_name, b.book_id\n"
//		+ "FROM students04 s FULL JOIN books04 b \n"
//		+ "ON s.std_id = b.student_id";
//
//		List <Object []> resultList6 = session.createSQLQuery(sqlQuery4).getResultList();
//		for(Object [] w: resultList6) {
//			System.out.println(Arrays.toString(w));
//		}
		
		
//		String hqlQuery4 = "SELECT s.name, b.book_name, b.book_id\n"
//				+ "FROM Students04 s FULL JOIN FETCH Books04 b \n"
//				+ "ON s.std_id = b.student";
//		
//		//  HQL IS CASE SENSITIVE
//		List <Object []> resultList7 = session.createQuery(hqlQuery4).getResultList();
//		for(Object [] w: resultList7) {
//			System.out.println(Arrays.toString(w));
//		}
		
//		// How to delete all records from a table
		//--------------------------------------------------------------------------
		
		// FROM CHILD TABLE
		
//		String sqlQuery5 = "DELETE FROM books04";
//		int numOfRecord1 = session.createSQLQuery(sqlQuery5).executeUpdate();
//		System.out.println(numOfRecord1);
//		
//		String hqlQuery6 = "DELETE FROM Books04";
//		int numOfRecord2 = session.createQuery(hqlQuery6).executeUpdate();
//		System.out.println("Number of Deleted Records:" + numOfRecord2);
		
		// Shortest way to delete all records in HQL
		
//		session.delete(student);
		
		//DELETE
		// 1.way Use delete (<Object Name>)
//		book = session.get(Books04.class, 101);
//		session.delete(book);
		
		// 2.way Use delete ((<Object Name as String>, <Object Name>)
//		book = session.get(Books04.class, 102);
//		session.delete("Books04", book);
		
		// FROM PARENT TABLE
		// Delete the record whose id is 1003 from Student04 table.
		// if a record has a child record, you cannot delete the parent record without deleting child record
		// ConstraintViolationException" at runtime
//		String hqlQuery8 = "DELETE FROM Students04 s "
//				+ "WHERE s.std_id = 1002";
//		int numOfRec4 = session.createQuery(hqlQuery8).executeUpdate();
//		System.out.println(numOfRec4);
		
		// if a record has no child record, you can delete the parent.
//		String hqlQuery9 = "DELETE FROM Students04 s "
//				+ "WHERE s.std_id = 1003";
//		int numOfRec5 = session.createQuery(hqlQuery9).executeUpdate();
//		System.out.println(numOfRec5);
		
		
		// without getting any exception.
		
//		// 1. Way : Not RECOMENDED
//		//1. step : delete the child record of 1002
//		book = session.get(Books04.class, 103);
//		session.delete(book);
//		//2. step : delete the parent 
//		student = session.get(Students04.class, 1002);
//		session.delete(student);
//	
		// 2. Way : 
		// 1. Step: a-) Go to parent class then 
		//			b-) @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.ALL) 
		
		student = session.get(Students04.class, 1001);
		session.delete(student);
	
		
		tx.commit();
		
		sf.close();
		session.close();
		

	}

}
