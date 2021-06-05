package h09.hql_queries;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Students_table")
public class Students09 {
	@Id
	private int id;
	@Column(name="Students_name")
	private String name;
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
