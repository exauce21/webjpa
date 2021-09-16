package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Academie;
import sn.isi.entities.Roles;

public class AcademieImpl implements  IAcademie {
	
	private EntityManager em;
	
	public AcademieImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}

	@Override
	public int add(Academie academie) {
		try {
			em.getTransaction().begin();
			em.persist(academie);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Academie academie) {
		try {
			em.getTransaction().begin();
			em.merge(academie);
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
			em.remove(em.find(Academie.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Academie get(int id) {
		return em.find(Academie.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Academie> getAll() {
		try {
			return em.createNamedQuery("academies.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
