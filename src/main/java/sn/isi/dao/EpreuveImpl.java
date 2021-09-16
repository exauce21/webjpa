package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Enseignant;
import sn.isi.entities.Epreuve;

public class EpreuveImpl implements IEpreuve {
	
	private EntityManager em;
	
	public EpreuveImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}

	@Override
	public int add(Epreuve epreuve) {
		try {
			em.getTransaction().begin();
			em.persist(epreuve);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Epreuve epreuve) {
		try {
			em.getTransaction().begin();
			em.merge(epreuve);
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
			em.remove(em.find(Epreuve.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Epreuve get(int id) {
		return em.find(Epreuve.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Epreuve> getAll() {
		try {
			return em.createNamedQuery("epreuves.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
