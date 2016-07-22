package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.modelo.Tarefa;



public class AdicionaTarefa {
	public static void main(String[] args) {
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Estudar JPA e Hibernate");
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		System.out.println(tarefa.getDescricao());
		System.out.println(tarefa.getId());
		System.out.println(tarefa.getDataFinalizacao());
		System.out.println(tarefa.getClass());
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("tarefa");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		System.out.println("ID da tarefa: " + tarefa.getId());
		manager.close();
	}
}
	