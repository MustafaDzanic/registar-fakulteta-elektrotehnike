package models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Usmjerenje 
{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String naziv;
	//private String skracenica;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usm_pred_join", 
	            joinColumns = { @JoinColumn(name = "usm_id")}, 
	            inverseJoinColumns={@JoinColumn(name="pred_id")})  
	private Collection<Predmet> predmeti;
	@OneToMany(mappedBy="usmjerenje")
	private Collection<Student> studenti;
	
	
	public Collection<Student> getStudenti() {
		return studenti;
	}
	public void setStudenti(Collection<Student> studenti) {
		this.studenti = studenti;
	}
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
	/*public String getSkracenica() {
		return skracenica;
	}
	public void setSkracenica(String skracenica) {
		this.skracenica = skracenica;
	}*/

	public Collection<Predmet> getPredmeti() {
		if(predmeti==null)
			predmeti=new ArrayList<Predmet>();		
		return predmeti;
	}
	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public String getListPredmeti()
	{
		StringBuilder stringBuilder = new StringBuilder();
		int i=0;
		for(Predmet pr : predmeti)
		{
			stringBuilder.append(pr.getNaziv());
			if(i<predmeti.size()-1)
				stringBuilder.append(", ");
			i++; 
		}
		return stringBuilder.toString();
	}
	@Override
	public String toString() 
	{
		return this.naziv;
	}
	
	
	
}
