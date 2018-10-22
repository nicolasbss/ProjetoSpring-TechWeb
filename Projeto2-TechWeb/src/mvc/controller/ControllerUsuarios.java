package mvc.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.DAO;
import mvc.model.Pessoas;

@Controller
public class ControllerUsuarios {
	
	@RequestMapping("/login")
	public String inicial() {
		return "login";
	}
	
	@RequestMapping("/AutenticaUsuario")
	public String autenticaLogin(HttpSession session,
			@RequestParam(value = "login") String login,
			@RequestParam(value = "senha") String senha) {
		
		DAO dao = new DAO();
		Pessoas pessoa = new Pessoas();
		
		
		pessoa.setLogin(login);
		pessoa.setSenha(senha);
		
		int id = dao.autenticaUsuario(pessoa);
		if (id == 0) {
			return "login";
		} else {
			session.setAttribute("usuario", id);
			
			return "index";
		}				
	}
	
	@RequestMapping(value = "Cadastro", method = RequestMethod.GET)
	public String redirectCadastro(){
		return "criapessoas";
	}
	
	@RequestMapping(value = "Cadastro", method = RequestMethod.POST)
	public String cadastraUsuario(HttpSession session,
			@RequestParam(value = "login") String login,
			@RequestParam(value = "senha") String senha) {
		DAO dao = new DAO();
		Pessoas pessoa = new Pessoas();
		
		pessoa.setLogin(login);
		pessoa.setSenha(senha);
		
		dao.adicionaPessoa(pessoa);
		
		return "login";
	}
	
	@RequestMapping(value = "AlteraCredenciais", method = RequestMethod.GET)
	public String redirectAlteraCredenciais(HttpSession session,
			@RequestParam(value = "pessoa_id") String pessoa_id) {
		
		session.setAttribute("pessoa_id", Integer.valueOf(pessoa_id));
		return "alteracredenciais";
	}
	
	@RequestMapping(value = "AlteraCredenciais", method = RequestMethod.POST)
	public String AlteraCredenciais(HttpSession session,
			@RequestParam(value = "pessoa_id") String pessoa_id,
			@RequestParam(value = "login") String login,
			@RequestParam(value = "senha") String senha) {
		
		DAO dao = new DAO();
		Pessoas pessoa = new Pessoas();
		pessoa.setLogin(login);
		pessoa.setSenha(senha);
		pessoa.setId(Integer.valueOf(pessoa_id));
		dao.alteraPessoa(pessoa);
	
		dao.close();
		
		session.setAttribute("usuario", Integer.valueOf(pessoa_id));
		// draw JSP
		
		return "index";
		
	}
	
}
