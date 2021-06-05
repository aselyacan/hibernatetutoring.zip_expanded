package h05.myhomework;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answers {
	
	@Id
	private int ans_id;
	private String answerBody;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Questions question;

	public int getAns_id() {
		return ans_id;
	}

	public void setAns_id(int ans_id) {
		this.ans_id = ans_id;
	}

	public String getAnswerBody() {
		return answerBody;
	}

	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answers [ans_id=" + ans_id + ", answerBody=" + answerBody + ", question=" + question + "]";
	}
	
	

}
