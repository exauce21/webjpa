package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Examen;

public class ExamenImpl implements IExamen{
	
	private EntityManager em;
	
	public ExamenImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(Examen examen) {
		try {
			em.getTransaction().begin();
			em.persist(examen);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Examen examen) {
		try {
			em.getTransaction().begin();
			em.merge(examen);
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
			em.remove(em.find(Examen.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Examen get(int id) {
		return em.find(Examen.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Examen> getAll() {
		try {
			return em.createNamedQuery("examens.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
