package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Eleve;

public interface IEleve {
	public int add(Eleve eleve);
	public int update(Eleve eleve);
	public int delete(int id);
	public Eleve get(int id);
	public List<Eleve> getAll();
}
