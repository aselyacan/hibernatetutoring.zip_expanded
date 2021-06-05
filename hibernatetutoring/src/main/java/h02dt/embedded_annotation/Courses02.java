package h02dt.embedded_annotation;

import javax.persistence.Embeddable;

@Embeddable
public class Courses02 {
	
	private String elective;
	private String mandatory;
	
	public String getElective() {
		return elective;
	}
	public void setElective(String elective) {
		this.elective = elective;
	}
	public String getMandatory() {
		return mandatory;
	}
	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}
	@Override
	public String toString() {
		return "Courses02 [elective=" + elective + ", mandatory=" + mandatory + "]";
	}
	

}
