package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Enseignant;

public interface IEnseignant {
	public int add(Enseignant enseignant);
	public int update(Enseignant enseignant);
	public int delete(int id);
	public Enseignant get(int id);
	public List<Enseignant> getAll();

}
