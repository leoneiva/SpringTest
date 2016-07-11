package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

// Redireciona para o jsp quando acessado o link /loginForm
@Controller
public class LoginController{
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}
	
// Verifica a existência do usuário
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if(new JdbcUsuarioDao().existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		return "redirect:loginForm";
	}
	
}
