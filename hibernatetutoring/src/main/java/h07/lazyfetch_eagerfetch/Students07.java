package h07.lazyfetch_eagerfetch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Students07 {
	
	@Id
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	private int grade;
	
	@OneToMany(mappedBy="student", fetch = FetchType.EAGER)
	private List<Books07> booksList = new ArrayList<Books07>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Books07> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Books07> booksList) {
		this.booksList = booksList;
	}

//	@Override
//	public String toString() {
//		return "Students07 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
//	}
//	
	@Override
	public String toString() {
		return "Students07 [id=" + id + ", name=" + name + ", grade=" + grade + ", booksList=" + booksList + "]";
	}
	
	
}
