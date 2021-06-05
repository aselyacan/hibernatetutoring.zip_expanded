package h03dt.onetoone_joins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {
	@Id
	private int id;
	private String diaryName;
	
	@OneToOne
	@JoinColumn(name="student_id")
	private Students03 student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiaryName() {
		return diaryName;
	}
	public void setDiaryName(String diaryName) {
		this.diaryName = diaryName;
	}
	@Override
	public String toString() {
		return "Diary [id=" + id + ", diaryName=" + diaryName + "]";
	}
	public Students03 getStudent() {
		return student;
	}
	public void setStudent(Students03 student) {
		this.student = student;
	}
	
	

}
