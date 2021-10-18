package com.cadastro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.cadastro.model.ContatoModel;
import com.cadastro.model.PessoaModel;
import com.cadastro.service.PessoaService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CadastroApplicationTests{
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Teste");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	@BeforeEach
	@Test
	void insertPessoa() {
		try{
			EntityManager manager = entityManagerFactory.createEntityManager();
			String strData = "1997/02/23";  
			Date dt = new SimpleDateFormat("yyyy/MM/dd").parse(strData);
			PessoaModel pessoa = new PessoaModel();
			pessoa.setCpf("0998455445");
			pessoa.setNome("Andre");
			pessoa.setDataNascimento(dt);
			manager.getTransaction().begin();
			manager.persist(pessoa);
			manager.getTransaction().commit();
		}catch(Exception ex){
			ex.getMessage();
		} 
	}

	@BeforeEach
	@Test
	void insertContato() {
		try{
			EntityManager manager = entityManagerFactory.createEntityManager();
			ContatoModel contato = new ContatoModel();
			Query q = entityManager.createNativeQuery("SELECT id, nome, cpf, data_nascimento FROM pessoa", new PessoaModel().getClass());
			List<PessoaModel> result = q.getResultList();
			for(PessoaModel p : result){
				contato.setEmail("teste@gmail.com");
				contato.setNome("Andre");
				contato.setTelefone(41995959559L);
				contato.setPessoa(p);
				manager.getTransaction().begin();
				manager.persist(contato);
			}
			
			manager.getTransaction().commit();
		}catch(Exception ex){
			ex.getMessage();
		} 
	}

	@BeforeEach
	@Test
	void listContato() {
		try{
			entityManager.getTransaction().begin();
			Query q = entityManager.createNativeQuery("SELECT id, email, nome, telefone FROM contato", new ContatoModel().getClass());
			List<ContatoModel> result = q.getResultList();
			for (ContatoModel contatoModel : result) {
				System.out.println(contatoModel);
			}
		}catch(Exception ex){
			ex.getMessage();
		} 
	}

	@BeforeEach
	@Test
	void delete(){
		try{
		entityManager.getTransaction().begin();
		Query q = entityManager.createNativeQuery("DELETE FROM pessoa");
		q.executeUpdate();
		entityManager.getTransaction().commit();
		}catch(Exception ex){
			ex.getMessage();
		} 
	}
}
