package h07.lazyfetch_eagerfetch;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Books07 {
	
	@Id
	private int id;
	
	private String book_name;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Students07 student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public Students07 getStudent() {
		return student;
	}

	public void setStudent(Students07 student) {
		this.student = student;
	}

//	@Override
//	public String toString() {
//		return "Books07 [id=" + id + ", book_name=" + book_name + ", student=" + student + "]";
//	}
//	
	@Override
	public String toString() {
		return "Books07 [id=" + id + ", book_name=" + book_name + "]";
	}
	

}
