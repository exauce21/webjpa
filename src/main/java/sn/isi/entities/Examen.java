package sn.isi.entities;

import java.io.Serializable;
import java.sql.Date;
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
	@NamedQuery(name = "examens.all", query = "SELECT e FROM Examen e")
})
public class Examen implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 100)
	private String nom;
	private Date date;
	
	@OneToMany(mappedBy = "examen")
	private List<Epreuve> epreuves  = new ArrayList<Epreuve>();
	
	@OneToMany(mappedBy = "examen")
	private List<Inscription> incriptions  = new ArrayList<Inscription>();
	
	@ManyToOne
	private Academie academie = new Academie();
	
	public Examen() {
		
	}

	public Examen(String nom, Date date, Academie academie) {
		this.nom = nom;
		this.date = date;
		this.academie = academie;
	}
	
	public Examen(int id, String nom, Date date, Academie academie) {
		this.id = id;
		this.nom = nom;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Epreuve> getEpreuves() {
		return epreuves;
	}

	public void setEpreuves(List<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}

	public List<Inscription> getIncriptions() {
		return incriptions;
	}

	public void setIncriptions(List<Inscription> incriptions) {
		this.incriptions = incriptions;
	}

	public Academie getAcademie() {
		return academie;
	}

	public void setAcademie(Academie academie) {
		this.academie = academie;
	}
	
	
}
