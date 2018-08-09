package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
public class Student 
{
	@Id	
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int student_id;
	private String prezime;
	private String ime;
	private String br_indeksa;
	//private String adresa;
	//private String telefon;
	private String semestar;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Usmjerenje usmjerenje;
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
	private Korisnik korisnik;
	@ManyToMany
	private Collection<Sekcija> sekcije;
	@ManyToMany(cascade=CascadeType.ALL)
	private Collection<Ispit> ispiti;
	@OneToMany(mappedBy="student")
	private Collection<RezultatIspita> rezultati;
	
	public int getId() {
		return student_id;
	}
	public void setId(int id) {
		this.student_id = id;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	/*public String getBr_indeksa() {
		return br_indeksa;
	}
	public void setBr_indeksa(String br_indeksa) {
		this.br_indeksa = br_indeksa;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}*/
	public Usmjerenje getUsmjerenje() {
		return usmjerenje;
	}
	public void setUsmjerenje(Usmjerenje usmjerenje) {
		this.usmjerenje = usmjerenje;
	}
	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public String getSemestar() {
		return semestar;
	}
	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}
	public Collection<Sekcija> getSekcije() {
		return sekcije;
	}
	public void setSekcije(Collection<Sekcija> sekcije) {
		this.sekcije = sekcije;
	}
	public Collection<Ispit> getIspiti() {
		if(ispiti==null)
			ispiti=new ArrayList<Ispit>();
		return ispiti;
	}
	public void setIspiti(Collection<Ispit> ispiti) {
		this.ispiti = ispiti;
	}
	public Collection<RezultatIspita> getRezultati() {
		return rezultati;
	}
	public void setRezultati(Collection<RezultatIspita> rezultati) {
		this.rezultati = rezultati;
	}
	
	@Override
	public String toString()
	{
		return this.br_indeksa + " - " + prezime + " " + ime;
	}
	

}
