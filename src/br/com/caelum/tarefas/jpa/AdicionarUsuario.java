package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Usuario;

public class AdicionarUsuario {
	public static void main(String[] args) {

		Usuario user = new Usuario();
		user.setLogin("abc");
		user.setSenha("123");
		
		System.out.println(user.getLogin());
		System.out.println(user.getSenha());
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("user");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		System.out.println("user: " + user.getLogin());
		manager.close();
	}
}
	