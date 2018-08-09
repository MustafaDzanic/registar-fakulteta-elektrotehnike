package models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Predmet 
{
	@Id	
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String naziv;
	//private String skracenica;
	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "predmeti")
	private Collection<Usmjerenje> usmjerenja;
	private int semestar;
	private Collection<Predmet> preduslovi;
	@OneToMany(mappedBy="predmet")
	private Collection<Sekcija> sekcije;

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
	//public String getSkracenica() {
	//	return skracenica;
	//}
	//public void setSkracenica(String skracenica) {
//		this.skracenica = skracenica;
//	}
	public Collection<Usmjerenje> getUsmjerenja() 
	{
		if(usmjerenja==null)
			usmjerenja=new ArrayList<Usmjerenje>();
		return usmjerenja;
	}
	public void setUsmjerenja(ArrayList<Usmjerenje> usmjerenja) {
		this.usmjerenja = usmjerenja;
	}
	
	public String getListUsmjerenja()
	{
		StringBuilder stringBuilder = new StringBuilder();
		int i=0;
		for(Usmjerenje us : usmjerenja)
		{
			stringBuilder.append(us.getNaziv());
			if(i<usmjerenja.size()-1)
				stringBuilder.append(", ");
			i++; 
		}
		return stringBuilder.toString();
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int sem) {
		semestar = sem;
	}
	public Collection<Predmet> getPreduslovi() {
		return preduslovi;
	}
	public void setPreduslovi(Collection<Predmet> preduslovi) {
		this.preduslovi = preduslovi;
	}

	@Override
	public String toString()
	{
		return naziv;
	}
	public Collection<Sekcija> getSekcije() 
	{
		if(sekcije==null)
			sekcije=new ArrayList<Sekcija>();
		return sekcije;
	}
	public void setSekcije(Collection<Sekcija> sekcije) {
		this.sekcije = sekcije;
	}
	
	
	
}
