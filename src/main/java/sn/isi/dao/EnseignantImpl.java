package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Enseignant;

public class EnseignantImpl implements IEnseignant {
	
	private EntityManager em;
	
	public EnseignantImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}
	

	@Override
	public int add(Enseignant enseignant) {
		try {
			em.getTransaction().begin();
			em.persist(enseignant);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Enseignant enseignant) {
		try {
			em.getTransaction().begin();
			em.merge(enseignant);
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
			em.remove(em.find(Enseignant.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Enseignant get(int id) {
		return em.find(Enseignant.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enseignant> getAll() {
		try {
			return em.createNamedQuery("enseignants.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
