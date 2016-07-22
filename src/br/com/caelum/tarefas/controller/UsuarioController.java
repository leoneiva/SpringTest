package br.com.caelum.tarefas.controller;

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
import br.com.caelum.tarefas.modelo.Usuario;


@Controller
public class UsuarioController {
	
		
	// acionada para abrir o formulário de add user
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

	
	
	// LISTA TAREFAS
	@RequestMapping("listaUsuarios")
	public String lista(Model model) {
		JdbcUsuarioDao dao = new JdbcUsuarioDao();
		model.addAttribute("usuarios", dao.lista());
		return "usuario/lista";
	}
	

	

}
	

