package sn.isi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "commissions.all", query = "SELECT c FROM Commission c")
})
public class Commission implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100)
	private String nom;

	@OneToMany(mappedBy = "commission")
	private List<Epreuve> epreuves  = new ArrayList<Epreuve>();
	
	@OneToMany(mappedBy = "commission")
	private List<Enseignant> enseignants  = new ArrayList<Enseignant>();
	
	@ManyToOne
	private Academie academie = new Academie();
	
	public Commission() {
		
	}

	public Commission(int id, String nom, Academie academie) {
		this.id = id;
		this.nom = nom;
		this.academie = academie;
	}
	
	public Commission(String nom, Academie academie) {
		this.nom = nom;
		this.academie = academie;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Enseignant> getEnseignants() {
		return enseignants;
	}
	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}
	public Academie getAcademie() {
		return academie;
	}
	public void setAcademie(Academie academie) {
		this.academie = academie;
	}

	public List<Epreuve> getEpreuves() {
		return epreuves;
	}

	public void setEpreuves(List<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}
	
}
