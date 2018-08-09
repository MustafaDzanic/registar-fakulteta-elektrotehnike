package models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Sekcija 
{
	@Id	
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String naziv;
	private int godina;
	@ManyToOne
	private Predmet predmet;
	@OneToMany(mappedBy="sekcija")
	private Collection<Ispit> ispiti;
	@ManyToMany(mappedBy="sekcije")
	private Collection<Student> studenti;
	private String semestar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public String getSemestar() {
		return semestar;
	}
	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}
	public Collection<Ispit> getIspiti() {
		if(ispiti==null)
			ispiti=new ArrayList<Ispit>();
		return ispiti;
	}
	public void setIspiti(Collection<Ispit> ispiti) {
		this.ispiti = ispiti;
	}
	
	@Override
	public String toString()
	{
		return naziv + " (" + this.predmet.getNaziv() + ")";
	}
	public Collection<Student> getStudenti() {
		if(studenti==null)
			studenti=new ArrayList<Student>();
		return studenti;
	}
	public void setStudenti(Collection<Student> studenti) {
		this.studenti = studenti;
	}
	
	public String getGodinaString()
	{
		return new Integer(godina).toString();
	}
	

}
