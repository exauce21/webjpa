package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Inscription;

public class InscriptionImpl implements IInscription {

	private EntityManager em;
	
	public InscriptionImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(Inscription inscription) {
		try {
			em.getTransaction().begin();
			em.persist(inscription);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Inscription inscription) {
		try {
			em.getTransaction().begin();
			em.merge(inscription);
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
			em.remove(em.find(Inscription.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Inscription get(int id) {
		return em.find(Inscription.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inscription> getAll() {
		try {
			return em.createNamedQuery("inscriptions.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
