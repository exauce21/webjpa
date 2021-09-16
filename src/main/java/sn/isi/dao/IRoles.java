package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Roles;

public interface IRoles {
	public int add(Roles role);
	public int update(Roles role);
	public int delete(int id);
	public Roles get(int id);
	public List<Roles> getAll();
}
