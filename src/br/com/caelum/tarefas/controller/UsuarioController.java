package br.com.caelum.tarefas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Tarefa;
import br.com.caelum.tarefas.modelo.Usuario;


@Controller
public class UsuarioController {
	
		
	// acionada para abrir o formul�rio de add user
	@RequestMapping("AdicionarUsuario")
	public String form() {
		return "usuario/formulario";
		
	}

	//acionada para executar classe dao add user
	@RequestMapping("salvaUsuario")
	public String adiciona(Usuario usuario, BindingResult result) {

JdbcUsuarioDao dao = new JdbcUsuarioDao();
		dao.adiciona(usuario);
		return "usuario/adicionado";
	}

	
	
	// LISTA USUARIO
	@RequestMapping("listaUsuarios")
	public String lista(Model model) {
		JdbcUsuarioDao dao = new JdbcUsuarioDao();
		model.addAttribute("usuarios", dao.lista());


		
		// abaixo vai passar o objeto da pagina��o. criar um objeto para calcular o tamanho do array e passar as variaveis para a pagina��o.
		// model.addAttribute("paginacao", dao.lista());

		return "usuario/lista";
	}
	

	// REMOVE TAREFA
	@RequestMapping("removeUsuario")
	public String remove(Usuario usuario) {
		JdbcUsuarioDao dao = new JdbcUsuarioDao();
		System.out.println(usuario.getId() + "id usuario");
		dao.remove(usuario);
		return "redirect:listaUsuarios"; // No return, redireciona para n�o carregar a lista novamente.
	}

	
	

}
	

