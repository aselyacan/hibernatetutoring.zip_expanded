package h11dt.sessionfactory_entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerWithEntityManager {

	public static void main(String[] args) {
		
		Students12 student3 = new Students12();
		student3.setId(1003);
		student3.setName("Mary Star");
		student3.setMathGrade(59);
		
		/*
		 EntityManagerFactory provides EntityManager instances.
		 EntityManagerFactory in JPA is similar with SessionFactory in Hibernate
		*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
		
		/*
		 EntityManager object is used to access methods in JPA.
		 EntityManager in JPA is similar with Session in Hibernate 
		*/
		EntityManager em = emf.createEntityManager();
		
		//To insert record into the table do the followings
		em.getTransaction().begin();//Similar with session.beginTransaction()
		//em.persist(student3);//similar with session.save(student3)
		
		//To fetch data from database
		Students12 rs1 = em.find(Students12.class, 1001); //Similar with the get()
		System.out.println(rs1);
		
		//To delete a record from table
		//Note: To be able to remove a record, you should fetch it first.
		//Note: If you try to delete a deleted record, remove() method throws "IllegalArgumentException" 
		//em.remove(rs1);
		
		//Remove Mary Star
		Students12 rs2 = em.find(Students12.class, 1003);
		em.remove(rs2);

		em.getTransaction().commit();//similar with tx.commit()
		
		em.close();//Similar with session.close()
		emf.close();//Similar with sf.close()
		

	}

}
