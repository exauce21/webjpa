package sn.isi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = "epreuves.all", query = "SELECT e FROM Epreuve e")
})
public class Epreuve implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 100)
	private String nom;
	
	@Column(length = 4)
	private int coef;
	
	@OneToOne(mappedBy = "epreuve")
	private Note note;
	
	@ManyToOne
	private Examen examen = new Examen();
	
	@ManyToOne
	private Commission commission = new Commission();

	public Epreuve() {
		
	}
	
	public Epreuve(int id, String nom, int coef, Examen examen, Commission commission) {
		this.id = id;
		this.nom = nom;
		this.coef = coef;
		this.examen = examen;
		this.commission = commission;
	}
	
	public Epreuve(String nom, int coef, Examen examen, Commission commission) {
		this.nom = nom;
		this.coef = coef;
		this.examen = examen;
		this.commission = commission;
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

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Commission getCommision() {
		return commission;
	}

	public void setCommision(Commission commission) {
		this.commission = commission;
	}
	
}
