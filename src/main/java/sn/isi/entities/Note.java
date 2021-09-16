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
	@NamedQuery(name = "notes.all", query = "SELECT n FROM Note n")
})
public class Note implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 4)
	private int valeur;
	
	@ManyToOne
	private Eleve eleve = new Eleve();
	
	@OneToOne
	private Epreuve epreuve ;

	public Note() {
	
	}

	public Note(int id, int valeur, Eleve eleve, Epreuve epreuve) {
		this.id = id;
		this.valeur = valeur;
		this.eleve = eleve;
		this.epreuve = epreuve;
	}

	public Note(int valeur, Eleve eleve, Epreuve epreuve) {
		this.valeur = valeur;
		this.eleve = eleve;
		this.epreuve = epreuve;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Epreuve getEpreuve() {
		return epreuve;
	}

	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}
	
}
