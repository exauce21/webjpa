package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Commission;

public interface ICommision {
	public int add(Commission commission);
	public int update(Commission commission);
	public int delete(int id);
	public Commission get(int id);
	public List<Commission> getAll();
}
