package h01dt.annotations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 	If you use "@Entity" annotation for a class, the class must have a)Constructor 
 																	 b)Create getters and setters for each variable
 																	 c)toString() is optional but do it
 																	 d)Do not define any field "static" or "final"
 																	 
 	If you use "@Entity" annotation for a class, it means Hibernate will be able create a table in DB and
 	the name of the table will be same with the name of the class as default.
 	If you want to use a different name for your table in DB, it is possible by using "@Table" annotation like 	
 	@Table(name = "students_table")	
	 	Note:When you use "@Table" annotation, you changed just the name of the table, you did not change the name 
	 	of the Entity.
	If you want to change the Entity and Table names together, you have 2 options;
	 	1)Change the class name
	 	2)If you do not want to change class name but you want to change Entity and Table names, you need to use "@Entity"
	 	annotation like " @Entity(name = "students_table_entity") "	
	 	
	 If you want to change column name without changing variable name, you nned to use "@Column" annotation like 
	" @Column(name = "std_name") "
*/

@Entity
@Table(name = "students_table")
public class Students01 {
	
	@Id
	private int std_id;
	
	private String name;

	private int grade;
	
	public int getId() {
		return std_id;
	}
	public void setId(int id) {
		this.std_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Students01 [id=" + std_id + ", name=" + name + ", grade=" + grade + "]";
	}

}
