package models;

import javax.persistence.*;


@Entity
public class Korisnik {
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String username;
	private String lozinka;
	private int role;
	
	public Korisnik()
	{
		
	}
	
	public Korisnik (int ID)
	{
		this.id=ID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
	
}

