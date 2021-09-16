package sn.isi.dao;

import java.util.List;

import sn.isi.entities.Note;

public interface INote {
	public int add(Note note);
	public int update(Note note);
	public int delete(int id);
	public Note get(int id);
	public List<Note> getAll();
}
