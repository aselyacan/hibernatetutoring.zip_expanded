package h03dt.onetoone_joins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerSave03 {

	public static void main(String[] args) {
		
		Diary diary1 = new Diary();
		Diary diary2 = new Diary();
		
		Students03 std1 = new Students03();
		Students03 std2 = new Students03();
		
		std1.setStd_id(101);
		std1.setName("Ali Can");
		std1.setGrade(11);
		std1.setDiary(diary1);
		
		std2.setStd_id(102);
		std2.setName("Veli Han");
		std2.setGrade(10);
		
		diary1.setId(11);
		diary1.setDiaryName(std1.getName()+ "'s Diary");
		diary1.setStudent(std1);
		
		diary2.setId(12);
		diary2.setDiaryName("Nobodsy's Diary");
	
		
		Configuration con = new Configuration().
				configure("hibernate12.cfg.xml").
				addAnnotatedClass(Students03.class).
				addAnnotatedClass(Diary.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		session.save(std1);
		session.save(std2);
		
		session.save(diary1);
		session.save(diary2);
		
		Transaction tx = session.beginTransaction();
		
		
		tx.commit();
		
		
		session.close();
		sf.close();
		
		
	}

}
