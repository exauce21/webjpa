package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Roles;
import sn.isi.entities.User;

public interface IUser {

	public int add(User user);
	public int update(User user);
	public int delete(int id);
	public User get(int id);
	public List<Roles> getAll();
	public User login(String username, String password);
}
