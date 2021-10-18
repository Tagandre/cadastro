package com.cadastro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cadastro.model.PessoaModel;

public class PersistenceDAO {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Teste");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void create(PessoaModel pessoaModel) {
		
		try{
			/*entityManager.getTransaction().begin();
			entityManager.persist(pessoaModel);
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();*/

		} finally {
		  entityManager.getTransaction().rollback();
		}
	  }

	public List<PessoaModel> listAll() { 
		entityManager.getTransaction().begin();
		Query q = entityManager.createNativeQuery("SELECT id, email, name, phone FROM teste", new PessoaModel().getClass());
		List<PessoaModel> result = q.getResultList();
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("oii->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return result;
	}
      
}
