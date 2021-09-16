package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Inscription;

public interface IInscription {

	public int add(Inscription inscription);
	public int update(Inscription inscription);
	public int delete(int id);
	public Inscription get(int id);
	public List<Inscription> getAll();
}
