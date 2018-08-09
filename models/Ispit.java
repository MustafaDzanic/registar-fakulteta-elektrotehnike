package models;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Ispit 
{
	@Id	
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int ispit_id;
	private String datum;
	private String vrijeme;
	@ManyToOne
	private Sekcija sekcija;
	//private String sala;
	//private int bodovi; imamo u RezultatIspita		
	private boolean tip;	//0=>ispit    1=>predispit
	@ManyToMany(mappedBy="ispiti")
	private Collection<Student> studenti;
	@OneToOne(mappedBy="ispit")
	private RezultatIspita rezultat;;
	public int getId() {
		return ispit_id;
	}
	public void setId(int id) {
		this.ispit_id = id;
	}
//nac nesto za autog
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public String getVrijeme() {
		return vrijeme;
	}
	public void setVrijeme(String vrijeme) {
		this.vrijeme = vrijeme;
	}
	public Sekcija getSekcija() {
		return sekcija;
	}
	public void setSekcija(Sekcija sekcija) {
		this.sekcija = sekcija;
	}
	/*public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public int getBodovi() {
		return bodovi;
	}
	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}*/
	public boolean getTip() {
		return tip;
	}
	public void setTip(boolean tip) {
		this.tip = tip;
	}
	public Collection<Student> getStudenti() {
		return studenti;
	}
	public void setStudenti(Collection<Student> studenti) {
		this.studenti = studenti;
	}
	public RezultatIspita getRezultat() {
		return rezultat;
	}
	public void setRezultat(RezultatIspita rezultat) {
		this.rezultat = rezultat;
	}
	
	@Override
	public String toString()
	{
		return (tip == true ? "Ispit: " : "Predispitna aktivnost: ") + datum + " u " + vrijeme;
	}
	
	
}
