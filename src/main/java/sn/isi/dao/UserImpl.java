package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Roles;
import sn.isi.entities.User;

public class UserImpl implements IUser {

	
	private EntityManager em;
	
	public UserImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(User user) {
		try {
			em.getTransaction().begin();
			em.merge(user);
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
			em.remove(em.find(User.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public User get(int id) {
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getAll() {
		try {
			//return em.createQuery("SELECT u FROM User u").getResultList();
			return em.createNamedQuery("user.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User login(String email, String password) {
		try {
			return (User) em.createNamedQuery("user.logon")
							.setParameter("email", email)
							.setParameter("password", password)
							.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
