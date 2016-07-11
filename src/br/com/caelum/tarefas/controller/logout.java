package br.com.caelum.tarefas.controller;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;

public class logout {

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
	
}
