package sn.isi.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "inscriptions.all", query = "SELECT i FROM Inscription i")
})
public class Inscription  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 20)
	private String numero;
	@Column(length = 10)
	private Date date;
	
	@ManyToOne
	private Eleve eleve = new Eleve();
	
	@ManyToOne
	private Examen examen = new Examen();

	public Inscription() {

	}
	
	public Inscription(String numero, Date date, Eleve eleve, Examen examen) {
		this.numero = numero;
		this.date = date;
		this.eleve = eleve;
		this.examen = examen;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	
	
	
	
	
}
