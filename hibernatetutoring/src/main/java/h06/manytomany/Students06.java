package h06.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


// Many to Many : Students >===> Library Books
// We need "Link Table" for ManyToMany relationship
// When we use many to many relation between Student06 and Books06 tables,
// Hibernate will create a) Student06 b) Books06 c)Students06_Books04 d) Books06_Students06 
// But if we have one linked list table, we don't need the other one. 
// So it is enough for us to select one of them.

@Entity
public class Students06 {

	@Id
	private int std_id;
	@Column(name="student_name")
	private String name;
	private int grade;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Students06_Books06", joinColumns = {@JoinColumn(name="std_id")},
										 inverseJoinColumns= {@JoinColumn(name="book_id")})
	private List<Books06> booksList = new ArrayList<Books06>();

	public int getStd_id() {
		return std_id;
	}

	public void setStd_id(int std_id) {
		this.std_id = std_id;
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

	public List<Books06> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Books06> booksList) {
		this.booksList = booksList;
	}

	@Override
	public String toString() {
		return "Students06 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + ", booksList=" + booksList
				+ "]";
	}

//	@Override
//	public String toString() {
//		return "Students06 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + ", booksList=" + booksList
//				+ "]";
//	}


}
