package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcPerfilDao;
import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;


@Controller
public class UsuarioController {
	
	//----------------------------------------------------------------	
	// ADICIONAR USER
	// acionada para abrir o formulário de add user
	@RequestMapping("novoUsuario")
	public String form(Model model) {
		PerfilController perfil = new PerfilController();
		perfil.lista(model);
		
		return "usuario/novo";
		
	}
	//acionada para executar classe dao add user
	@RequestMapping("salvaUsuario")
	public String adiciona(Usuario usuario, BindingResult result) {

		
System.out.println(usuario.getAtivo() + "   get ativo no controller");
JdbcUsuarioDao dao = new JdbcUsuarioDao();
		dao.adiciona(usuario);
		return "usuario/adicionadaSucesso";
	}
	//-----------------------------------------------------------------
	// LISTA USUARIO
	@RequestMapping("listaUsuarios")
	public String lista(Model model) {
		JdbcUsuarioDao dao = new JdbcUsuarioDao();
		model.addAttribute("usuarios", dao.lista());
		
		//TODO  abaixo vai passar o objeto da paginação. criar um objeto para calcular o tamanho do array e passar as variaveis para a paginação.
		// model.addAttribute("paginacao", dao.lista());

		return "usuario/lista";
	}
	//-----------------------------------------------------------------
	// REMOVE USUARIO
	@RequestMapping("removeUsuario")
	public String remove(Usuario usuario) {
		JdbcUsuarioDao dao = new JdbcUsuarioDao();
		System.out.println(usuario.getId() + "id usuario");
		dao.remove(usuario);
		return "redirect:listaUsuarios"; // No return, redireciona para não carregar a lista novamente.
	}
	//-----------------------------------------------------------------
	// Alterar user
	// acionada para abrir o formulário de add user
	@RequestMapping("alteraUsuario")
	public String mostra(Long id, Model model) {
		JdbcUsuarioDao dao = new JdbcUsuarioDao();
		JdbcPerfilDao daoPerfil = new JdbcPerfilDao();
		model.addAttribute("usuario", dao.buscaPorId(id));
		model.addAttribute("perfil", daoPerfil.lista());
		
		return "usuario/edita";
	}
	//acionada para executar classe dao add user
	@RequestMapping("salvaAlteracaoUsuario")
	public String salvaAlteracao(Usuario usuario, BindingResult result) {

JdbcUsuarioDao dao = new JdbcUsuarioDao();
		dao.altera(usuario);
		return "usuario/adicionadaSucesso";
	}
	

}
	

