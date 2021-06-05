package hibernate_review;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

@Cacheable  //We use second cache 
@Cache (usage=CacheConcurrencyStrategy.READ_WRITE,region="Students")
@Table(name="students")
public class Students {
	@Id
	@Column(name="std_id")
	@GeneratedValue(strategy = GenerationType.AUTO)  //for Automatic ID generation
	private int id;
	
	@Column(name="std_name")
	private String name;
	
	@Column(name="std_math_grade")
	private int mathGrade;
	
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
	public int getMathGrade() {
		return mathGrade;
	}
	public void setMathGrade(int mathGrade) {
		this.mathGrade = mathGrade;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", mathGrade=" + mathGrade + "]";
	}
	
}