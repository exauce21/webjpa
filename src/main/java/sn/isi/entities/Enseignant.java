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

@Entity
@NamedQueries({
	@NamedQuery(name = "enseignants.all", query = "SELECT e FROM Enseignant e")
})
public class Enseignant implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 10)
	private String matricule;
	@Column(length = 150)
	private String nom;
	@Column(length = 20)
	private int tel;
	@Column(length = 100)
	private String adresse;
	@Column(length = 30)
	private String ville;
	@Column(length = 100)
	private String email;
	@Column(length = 100)
	private String password;
	
	@ManyToOne
	private Commission commission = new Commission();
	
	@ManyToMany
	private List<Etablissement> etablissements = new  ArrayList<Etablissement>();
	
	public Enseignant() {
		
	}
	
	public Enseignant(String matricule, String nom, int tel, String adresse, String ville, String email) {
		this.matricule = matricule;
		this.nom = nom;
		this.tel = tel;
		this.adresse = adresse;
		this.ville = ville;
		this.email = email;
	}

	
	public Enseignant(String matricule, String nom, int tel, String adresse, String ville, String email,
			Commission commission, List<Etablissement> etablissements) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.tel = tel;
		this.adresse = adresse;
		this.ville = ville;
		this.email = email;
		this.commission = commission;
		this.etablissements = etablissements;
	}

	public Enseignant(int id, String matricule, String nom, int tel, String adresse, String ville, String email) {
		this.id = id;
		this.matricule = matricule;
		this.nom = nom;
		this.tel = tel;
		this.adresse = adresse;
		this.ville = ville;
		this.email = email;
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
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
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

	public Commission getCommission() {
		return commission;
	}

	public void setCommission(Commission commission) {
		this.commission = commission;
	}

	public List<Etablissement> getEtablissements() {
		return etablissements;
	}

	public void setEtablissements(List<Etablissement> etablissements) {
		this.etablissements = etablissements;
	}

	
	
	
}
