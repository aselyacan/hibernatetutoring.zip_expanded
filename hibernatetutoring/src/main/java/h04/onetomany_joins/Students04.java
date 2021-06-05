package h04.onetomany_joins;

//POJO : Plain Old Java Object

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Students04 {
	
	@Id
	private int std_id;
	private String name;
	private int grade;
	
//	@OneToMany(mappedBy = "student")
	@OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Books04> booksList = new ArrayList<Books04>();
	
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
	public List<Books04> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<Books04> booksList) {
		this.booksList = booksList;
	}
	@Override
	public String toString() {
		return "Students04 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + ", booksList=" + booksList
				+ "]";
	}
	
	
	
	

}
