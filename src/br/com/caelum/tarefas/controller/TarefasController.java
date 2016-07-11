package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;


// REDIRECIONA E ACIONA OBJETO DAO DA AÇÃO
// OBJETO DAO QUE FAZ A OPERAÇÃO


@Controller
public class TarefasController {

	// Formulário de tarefa
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}


	// ADICIONA TAREFA
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}


	// LISTA TAREFAS
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}


	// MOSTRA TAREFA POR ID
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra";
	}


	// REMOVE TAREFA
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);
		return "redirect:listaTarefas"; // No return, redireciona para não carregar a lista novamente.
	}


	// ALTERA TAREFA
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	
	// FINALIZA TAREFA AJAX
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id, HttpServletResponse response) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
		response.setStatus(200);
	}
	
	
	}


