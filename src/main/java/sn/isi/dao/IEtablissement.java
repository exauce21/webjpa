package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Etablissement;

public interface IEtablissement {
	public int add(Etablissement etablissement);
	public int update(Etablissement etablissement);
	public int delete(int id);
	public Etablissement get(int id);
	public List<Etablissement> getAll();

}
