package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcCategoriaDao;
import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Categoria;
import br.com.caelum.tarefas.modelo.Usuario;


@Controller
public class CategoriaController {
	
	//----------------------------------------------------------------	
	// ADICIONAR CATEGORIA
	// acionada para abrir o formulário de add u
	@RequestMapping("novaCategoria")
	public String form() {
		return "configuracoes/categoria/novo";
		
	}
	//acionada para executar classe dao add user
	@RequestMapping("salvaCategoria")
	public String adiciona(Categoria categoria, BindingResult result) {

JdbcCategoriaDao dao = new JdbcCategoriaDao();
		dao.adiciona(categoria);
		return "configuracoes/categoria/adicionadaSucesso";
	}
	//-----------------------------------------------------------------
	// LISTA PERFIL
	@RequestMapping("listaCategoria")
	public String lista(Model model) {
		JdbcCategoriaDao dao = new JdbcCategoriaDao();
		model.addAttribute("categoria", dao.lista());
		
		//TODO  abaixo vai passar o objeto da paginação. criar um objeto para calcular o tamanho do array e passar as variaveis para a paginação.
		// model.addAttribute("paginacao", dao.lista());

		return "configuracoes/categoria/lista";
	}
	//-----------------------------------------------------------------
	// REMOVE USUARIO
	@RequestMapping("removeCategoria")
	public String remove(Categoria categoria) {
		JdbcCategoriaDao dao = new JdbcCategoriaDao();
		System.out.println(categoria.getId() + "id categoria");
		dao.remove(categoria);
		return "redirect:listaCategoria"; // No return, redireciona para não carregar a lista novamente.
	}
	//-----------------------------------------------------------------
	// Alterar user
	// acionada para abrir o formulário de add user
	@RequestMapping("alteraCategoria")
	public String mostra(Long id, Model model) {
		JdbcCategoriaDao dao = new JdbcCategoriaDao();
		model.addAttribute("categoria", dao.buscaPorId(id));
		return "configuracoes/categoria/edita";
	}
	//acionada para executar classe dao add user
	@RequestMapping("salvaAlteracaoCategoria")
	public String salvaAlteracao(Categoria categoria, BindingResult result) {

JdbcCategoriaDao dao = new JdbcCategoriaDao();
		dao.altera(categoria);
		return "configuracoes/categoria/adicionadaSucesso";
	}
	

}
	

