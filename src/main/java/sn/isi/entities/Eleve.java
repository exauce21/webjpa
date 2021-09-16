package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
	@NamedQuery(name = "eleves.all", query = "SELECT e FROM Eleve e")
})
public class Eleve implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 20)
	private String matricule;
	@Column(length = 100)
	private String nom;
	@Column(length = 150)
	private String prenom;
	@Column(length = 100)
	private String email;
	@Column(length = 100)
	private String password;
	@Column(length = 10)
	private String datenaiss;
	
	@ManyToOne
	private Etablissement etablissement = new Etablissement();
	
	@OneToMany(mappedBy = "eleve")
	private List<Inscription> incriptions  = new ArrayList<Inscription>();
	
	@OneToMany(mappedBy = "eleve")
	private List<Note> notes  = new ArrayList<Note>();
	
	public Eleve() {
		
	}

	public Eleve(String matricule, String nom, String prenom, String email, String password, String datenaiss,
			Etablissement etablissement) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.datenaiss = datenaiss;
		this.etablissement = etablissement;
	}

	public Eleve(int id, String matricule, String nom, String prenom, String email, String password, String datenaiss,
			Etablissement etablissement) {
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.datenaiss = datenaiss;
		this.etablissement = etablissement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatenaiss() {
		return datenaiss;
	}

	public void setDatenaiss(String datenaiss) {
		this.datenaiss = datenaiss;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}

	public List<Inscription> getIncriptions() {
		return incriptions;
	}

	public void setIncriptions(List<Inscription> incriptions) {
		this.incriptions = incriptions;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	
	
	
	
	
	
	

}
