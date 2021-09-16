package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Note;

public class NoteImpl implements INote {
	
    private EntityManager em;
	
	public NoteImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}

	@Override
	public int add(Note note) {
		try {
			em.getTransaction().begin();
			em.persist(note);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Note note) {
		try {
			em.getTransaction().begin();
			em.merge(note);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			em.getTransaction().begin();
			em.remove(em.find(Note.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Note get(int id) {
		return em.find(Note.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Note> getAll() {
		try {
			return em.createNamedQuery("notes.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
