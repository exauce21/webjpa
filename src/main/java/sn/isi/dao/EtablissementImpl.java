package sn.isi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sn.isi.entities.Etablissement;
import sn.isi.entities.Roles;

public class EtablissementImpl implements IEtablissement{

 private EntityManager em;
	
	public EtablissementImpl() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("webjpa");
		em = emf.createEntityManager();
	}
	
	@Override
	public int add(Etablissement etablissement) {
		try {
			em.getTransaction().begin();
			em.persist(etablissement);
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(Etablissement etablissement) {
		try {
			em.getTransaction().begin();
			em.merge(etablissement);
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
			em.remove(em.find(Etablissement.class, id));
			em.getTransaction().commit();
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Etablissement get(int id) {
		return em.find(Etablissement.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etablissement> getAll() {
		try {
			return em.createNamedQuery("etablissements.all").getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
