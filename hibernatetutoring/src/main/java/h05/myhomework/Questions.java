package h05.myhomework;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
1)Create Question entity
2)Create Answer entity
3)Create one to many relationship between Question and Answer
4)Make the Question parent table, Answer child table
5)Create RunnerSave class to create tables and insert records
6)Insert at least 2 questions, and at least 3 answers for each question
7)Create RunnerFetch class to fetch records by using INNER, RIGHT, LEFT, FULL joins.
*/

@Entity
public class Questions {
	
	@Id
	private int id;
	private String questionBody;
	
	@OneToMany(mappedBy = "question")
	private List <Answers> answersList = new ArrayList<Answers>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuestionBody() {
		return questionBody;
	}
	public void setQuestionBody(String questionBody) {
		this.questionBody = questionBody;
	}
	public List<Answers> getAnswersList() {
		return answersList;
	}
	public void setAnswersList(List<Answers> answersList) {
		this.answersList = answersList;
	}
	@Override
	public String toString() {
		return "Questions [id=" + id + ", questionBody=" + questionBody + ", answersList=" + answersList + "]";
	}
	
		

}
