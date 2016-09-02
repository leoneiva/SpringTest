package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcPrioridadeDao;
import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Prioridade;
import br.com.caelum.tarefas.modelo.Usuario;


@Controller
public class PrioridadeController {
	
	//----------------------------------------------------------------	
	// ADICIONAR PRIORIDADE
	// acionada para abrir o formulário de add u
	@RequestMapping("novaPrioridade")
	public String form() {
		return "configuracoes/prioridade/novo";
		
	}
	//acionada para executar classe dao add user
	@RequestMapping("salvaPrioridade")
	public String adiciona(@Valid Prioridade prioridade, BindingResult result) {

		if(result.hasFieldErrors("prioridade")) {
			return "configuracoes/prioridade/lista";
		}
		
		
JdbcPrioridadeDao dao = new JdbcPrioridadeDao();
		dao.adiciona(prioridade);
		return "configuracoes/prioridade/adicionadaSucesso";
	}
	//-----------------------------------------------------------------
	// LISTA PERFIL
	@RequestMapping("listaPrioridade")
	public String lista(Model model) {
		JdbcPrioridadeDao dao = new JdbcPrioridadeDao();
		model.addAttribute("prioridade", dao.lista());
		
		//TODO  abaixo vai passar o objeto da paginação. criar um objeto para calcular o tamanho do array e passar as variaveis para a paginação.
		// model.addAttribute("paginacao", dao.lista());

		return "configuracoes/prioridade/lista";
	}
	//-----------------------------------------------------------------
	// REMOVE USUARIO
	@RequestMapping("removePrioridade")
	public String remove(Prioridade prioridade) {
		JdbcPrioridadeDao dao = new JdbcPrioridadeDao();
		System.out.println(prioridade.getId() + "id prioridade");
		dao.remove(prioridade);
		return "redirect:listaPrioridade"; // No return, redireciona para não carregar a lista novamente.
	}
	//-----------------------------------------------------------------
	// Alterar user
	// acionada para abrir o formulário de add user
	@RequestMapping("alteraPrioridade")
	public String mostra(Long id, Model model) {
		JdbcPrioridadeDao dao = new JdbcPrioridadeDao();
		model.addAttribute("prioridade", dao.buscaPorId(id));
		return "configuracoes/prioridade/edita";
	}
	//acionada para executar classe dao add user
	@RequestMapping("salvaAlteracaoPrioridade")
	public String salvaAlteracao(Prioridade prioridade, BindingResult result) {

JdbcPrioridadeDao dao = new JdbcPrioridadeDao();
		dao.altera(prioridade);
		return "configuracoes/prioridade/adicionadaSucesso";
	}
	

}
	

