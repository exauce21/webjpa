package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Examen;

public interface IExamen {
	public int add(Examen examen);
	public int update(Examen examen);
	public int delete(int id);
	public Examen get(int id);
	public List<Examen> getAll();
}
