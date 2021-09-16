package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Eleve;
import sn.isi.entities.Enseignant;

public class EleveImpl implements IEleve {
	
	private EntityManager em;
	
	public EleveImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}

	@Override
	public int add(Eleve eleve) {
		try {
			em.getTransaction().begin();
			em.persist(eleve);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Eleve eleve) {
		try {
			em.getTransaction().begin();
			em.merge(eleve);
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
			em.remove(em.find(Eleve.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Eleve get(int id) {
		return em.find(Eleve.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Eleve> getAll() {
		try {
			return em.createNamedQuery("eleves.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
