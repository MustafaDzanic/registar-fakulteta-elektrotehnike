package models;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Nastavnik 
{
	@Id	
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String prezime;
	private String ime;
//	private String zvanje;
//	private String adresa;
//	private String telefon;
	//@ManyToOne()
//	private RadnoMjesto radnoMjesto;
	//@OneToOne(cascade={CascadeType.REMOVE}) 
	private boolean isAssistent;
	private Korisnik korisnik;
	@ManyToMany
	private Collection<Predmet> predmetiNast;	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	/*public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
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
	}
	public RadnoMjesto getRadnoMjesto() {
		return radnoMjesto;
	}
	public void setRadnoMjesto(RadnoMjesto radnoMjesto) {
		this.radnoMjesto = radnoMjesto;
	}*/

	public Korisnik getKorisnik() {
		return korisnik;
	}
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public Collection<Predmet> getPredmeti() {
		if(predmetiNast==null)
			predmetiNast=new ArrayList<Predmet>();
		return predmetiNast;
	}
	public void setPredmeti(Collection<Predmet> predmeti) {
		this.predmetiNast = predmeti;
	}
	
	public String getListPredmeti()
	{
		StringBuilder stringBuilder = new StringBuilder();
		int i=0;
		for(Predmet pr : predmetiNast)
		{
			stringBuilder.append(pr.getNaziv());
			if(i<predmetiNast.size()-1)
				stringBuilder.append(", ");
			i++; 
		}
		return stringBuilder.toString();
	}
		
}
