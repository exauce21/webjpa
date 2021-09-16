package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Roles;
import sn.isi.entities.User;

public class RolesImpl implements IRoles{

private EntityManager em;
	
	public RolesImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(Roles role) {
		try {
			em.getTransaction().begin();
			em.persist(role);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Roles role) {
		try {
			em.getTransaction().begin();
			em.merge(role);
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
			em.remove(em.find(Roles.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Roles get(int id) {
		return em.find(Roles.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getAll() {
		try {
			return em.createNamedQuery("roles.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
