package h03dt.onetoone_joins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

// One to one relationship is like Students and Diary relationship.
// For every Student you will have  a single diary and vice versa.
// Student <===> Diary

@Entity
public class Students03 {
	
	@Id
	private int std_id;
	
	@Column(name="std_name")
	private String name;
	
	private int grade;
	
	@OneToOne(mappedBy = "student")
	private Diary diary;
	
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
	@Override
	public String toString() {
		return "Students02 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + "]";
	}
	public Diary getDiary() {
		return diary;
	}
	public void setDiary(Diary diary) {
		this.diary = diary;
	}
	

}
