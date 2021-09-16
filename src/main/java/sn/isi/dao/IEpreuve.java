package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Epreuve;

public interface IEpreuve {
	public int add(Epreuve epreuve);
	public int update(Epreuve epreuve);
	public int delete(int id);
	public Epreuve get(int id);
	public List<Epreuve> getAll();
}
