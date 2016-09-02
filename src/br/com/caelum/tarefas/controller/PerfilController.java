package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcPerfilDao;
import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Perfil;
import br.com.caelum.tarefas.modelo.Usuario;


@Controller
public class PerfilController {
	
	//----------------------------------------------------------------	
	// ADICIONAR PERFIL
	// acionada para abrir o formulário de add u
	@RequestMapping("novoPerfil")
	public String form() {
		return "configuracoes/perfil/novo";
		
	}
	//acionada para executar classe dao add user
	@RequestMapping("salvaPerfil")
	public String adiciona(Perfil perfil, BindingResult result) {

JdbcPerfilDao dao = new JdbcPerfilDao();
		dao.adiciona(perfil);
		return "configuracoes/perfil/adicionadaSucesso";
	}
	//-----------------------------------------------------------------
	// LISTA PERFIL
	@RequestMapping("listaPerfil")
	public String lista(Model model) {
		JdbcPerfilDao dao = new JdbcPerfilDao();
		model.addAttribute("perfil", dao.lista());
		
		//TODO  abaixo vai passar o objeto da paginação. criar um objeto para calcular o tamanho do array e passar as variaveis para a paginação.
		// model.addAttribute("paginacao", dao.lista());

		return "configuracoes/perfil/lista";
	}
	//-----------------------------------------------------------------
	// REMOVE USUARIO
	@RequestMapping("removePerfil")
	public String remove(Perfil perfil) {
		JdbcPerfilDao dao = new JdbcPerfilDao();
		System.out.println(perfil.getId() + "id perfil");
		dao.remove(perfil);
		return "redirect:listaPerfil"; // No return, redireciona para não carregar a lista novamente.
	}
	//-----------------------------------------------------------------
	// Alterar user
	// acionada para abrir o formulário de add user
	@RequestMapping("alteraPerfil")
	public String mostra(Long id, Model model) {
		JdbcPerfilDao dao = new JdbcPerfilDao();
		model.addAttribute("perfil", dao.buscaPorId(id));
		return "configuracoes/perfil/edita";
	}
	//acionada para executar classe dao add user
	@RequestMapping("salvaAlteracaoPerfil")
	public String salvaAlteracao(Perfil perfil, BindingResult result) {

JdbcPerfilDao dao = new JdbcPerfilDao();
		dao.altera(perfil);
		return "configuracoes/perfil/adicionadaSucesso";
	}
	

}
	

