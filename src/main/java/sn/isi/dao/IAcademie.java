package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Academie;

public interface IAcademie {
	public int add(Academie academie);
	public int update(Academie academie);
	public int delete(int id);
	public Academie get(int id);
	public List<Academie> getAll();
}
