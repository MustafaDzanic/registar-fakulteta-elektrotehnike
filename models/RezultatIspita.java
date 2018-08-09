package models;

import javax.persistence.*;


@Entity
public class RezultatIspita 
{
	@Id
	@ManyToOne
	private Student student;
	@Id
	@ManyToOne
	private Ispit ispit;
	private float bodovi;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Ispit getIspit() {
		return ispit;
	}
	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}
	public float getBodovi() {
		return bodovi;
	}
	public void setBodovi(float bodovi) {
		this.bodovi = bodovi;
	}
	public String getBodoviString()
	{
		return new Float(bodovi).toString();
	}	
}
