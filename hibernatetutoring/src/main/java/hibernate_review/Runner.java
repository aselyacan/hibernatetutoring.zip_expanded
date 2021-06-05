package hibernate_review;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner {
	
	//For JPA 
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 

	
	public static void main(String[] args) {
		
		createStudentTable();
		updateStudent(1,"John Travolta",33);
		updateStudent(2,"Micheal Jordan ",22);
		addStudent("Kerim Can",55);
		addStudent("Melih Göral",100);
		addStudent("Melih Göral",55);
	
		getStudentsByName("John Travolta");
		getStudentsByName("Melih Göral");
		getStudentById(1);
		deleteStudentById(2);
		getAllStudents();
	}
	
	// CRUD ===> Create operation with Hibernate
	public static void createStudentTable() {
		//This method creates "students" table and save 5 records.
		//IDs are assigned automatically

		//Configuration for Hibernate 
		Configuration con = new Configuration().
				configure("hibernate12.cfg.xml").
				addAnnotatedClass(Students.class);
				
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Random r = new Random();
		for(int i=1; i<=5; i++) {	
			Students student = new Students();
			student.setName("Name" + i);
			student.setMathGrade(r.nextInt(100));
			session.save(student);	
		}
	
		tx.commit();
		session.close();
		
	}
	// CRUD ===> Updating with JPA
	public static void addStudent(String name, int mathGrade) {
		// This method adds a new record into "students" table.
		// ID is assigned automatically
		Students student = new Students();
        
		EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        student.setName(name);
        student.setMathGrade(mathGrade);
        em.persist(student);
        System.out.println("---------------- ADDED ----------------");
        System.out.println(student +" added");
        em.getTransaction().commit();
        em.close();
        
    }
	// CRUD ===> Updating with JPA
	public static void updateStudent(int id, String name, int mathGrade) {
		// This method updates an existing record.
		
		Students student = null;	
	 	EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	
		student = em.find(Students.class, id);
			
		if(student==null) {
			System.out.println("Student "+id+ " is not exist");
		}else{
			student.setName(name);
			student.setMathGrade(mathGrade);
			System.out.println("---------------- UPDATE ----------------");
			System.out.println(student.getName() + " updated..");
			em.persist(student);
		
		}
		em.getTransaction().commit();
		em.close();
	}
	// CRUD ===> Deleting with JPA
	public static void deleteStudentById(int id) {
		// This method deletes an existing record.
		Students student = null;
		EntityManager em = emf.createEntityManager();
	
		em.getTransaction().begin();
		student = em.find(Students.class, id);
			
		if(student==null) {
			System.out.println("Student "+id+ " is not exist");
		}else{
			System.out.println("---------------- DELETE ----------------");
			System.out.println(student.getName() + " deleted..");
			em.remove(student);
		}
		em.getTransaction().commit();
		em.close();
    }
	
	// CRUD ===> Reading with JPA
	public static void getStudentById(int id) {
		// This method gets a record from "students" table
		
		Students student = null;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// stdID is a variable. So we must inform JPA. 
		// By the help of setParameter("stdID", id) command
		// JPA knows that stdId's value came from methods argument(id)
		
		String query = "SELECT s FROM Students s WHERE s.id = :stdID";
    	TypedQuery<Students> result = em.createQuery(query, Students.class);
    	result.setParameter("stdID", id);
    	
    	System.out.println("---------------- GET BY ID ----------------");
    	try {
    		student = result.getSingleResult();
    		System.out.println("ID:" +student.getId() + " NAME:"+student.getName() + " MATH GRADE:"+student.getMathGrade());
    	}
    	catch(NoResultException ex) {
    		System.out.println("Student "+id+ " is not exist");
    	}
    	finally {
    		em.close();
    	}
    }
	// CRUD ===> Reading with JPA
	public static void getStudentsByName(String name) {
		// This method gets the records according to the names.
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// stdName is a variable. So we must inform JPA. 
		// By the help of setParameter("stdName", name) command
		// JPA knows that stdName's value came from methods argument(name)
    	String query = "SELECT s FROM Students s WHERE s.name = :stdName";
    	TypedQuery<Students> result = em.createQuery(query, Students.class);
    	result.setParameter("stdName", name);
    	System.out.println("---------------- GET BY NAME ----------------");
    	
    	List<Students> studentsList=result.getResultList();
    	if(studentsList.size()==0) {
    		System.out.println(name + " is not exist in the table");
    	}else {
	    	for(Students w:studentsList ) {
	    		System.out.println("ID:" +w.getId() + " NAME:"+w.getName() + " MATH GRADE:"+w.getMathGrade());
	    	}
    	}
    	
    	em.close();
    }
	
	// CRUD ===> Reading with JPA
	public static void getAllStudents() {
		//This method gets all records from table.
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
    	TypedQuery<Students> result = em.createQuery("FROM Students", Students.class);
    	List<Students> studentsList=result.getResultList();
    	System.out.println("---------------- GET ALL STUDENTS  ----------------");
    	if(studentsList.size()==0) {
    		System.out.println("There is no student in the table");
    	}else {
	    	for(Students w:studentsList ) {
	    		System.out.println("ID:" +w.getId() + " NAME:"+w.getName() + " MATH GRADE:"+w.getMathGrade());
	    	}
    	}
    	
    	em.close();
    }	
	
}
