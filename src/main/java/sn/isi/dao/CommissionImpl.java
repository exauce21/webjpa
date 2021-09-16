package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Commission;

public class CommissionImpl implements ICommision {

private EntityManager em;
	
	public CommissionImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(Commission commission) {
		try {
			em.getTransaction().begin();
			em.persist(commission);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Commission commission) {
		try {
			em.getTransaction().begin();
			em.merge(commission);
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
			em.remove(em.find(Commission.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Commission get(int id) {
		return em.find(Commission.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commission> getAll() {
		try {
			return em.createNamedQuery("commissions.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
