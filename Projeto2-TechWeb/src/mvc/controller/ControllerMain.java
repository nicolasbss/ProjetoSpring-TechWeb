package mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.DAO;
import mvc.model.Notas;

@Controller
public class ControllerMain {
	
	@RequestMapping("/CriaNotas")
	public String redirectCriaNotas(HttpSession session,
			@RequestParam(value = "pessoa_id") String id_string) {
		Integer id = Integer.valueOf(id_string);
		session.setAttribute("pessoa_id", id);
		return "crianotas";
	}
	
	@RequestMapping(value = "CriaNotas", method = RequestMethod.POST)
	public String criaNotas(HttpSession session,
			@RequestParam(value = "tipo") String tipo,
			@RequestParam(value = "conteudo") String conteudo,
			@RequestParam(value = "pessoa_id") String pessoa_id) {
		
		DAO dao = new DAO();
		Notas nota = new Notas();
		
		nota.setTipo(tipo);
		nota.setDateTime();
		nota.setConteudo(conteudo);
		nota.setPessoa_id(Integer.valueOf(pessoa_id));
		
		dao.adicionaNota(nota);
		
		session.setAttribute("usuario", Integer.valueOf(pessoa_id));
		
		return "index";
	}
	
	@RequestMapping(value = "RemoveNota", method = RequestMethod.POST)
	public String removeNota(HttpSession session,
			@RequestParam(value = "id") String id){
		
		DAO dao = new DAO();
		dao.removeNota(Integer.valueOf(id));
		dao.close();
		
		session.setAttribute("usuario", Integer.valueOf(id));
		
		return "index";
	}
	
	@RequestMapping(value = "AtualizaNotas", method = RequestMethod.GET)
	public String redirectAtualizaNota(HttpSession session,
			@RequestParam(value = "id") String id,
			@RequestParam(value = "pessoa_id") String pessoa_id){
		
		
		
		session.setAttribute("idNota", Integer.valueOf(id));
		session.setAttribute("pessoa_id", Integer.valueOf(pessoa_id));
		
		return "atualizanotas";
	}
	
	@RequestMapping(value = "AtualizaNotas", method = RequestMethod.POST)
	public String atualizaNota(HttpSession session,
			@RequestParam(value = "id") String id,
			@RequestParam(value = "pessoa_id") String pessoa_id,
			@RequestParam(value = "tipo") String tipo,
			@RequestParam(value = "conteudo") String conteudo) {
		
		DAO dao = new DAO();
		Notas nota = new Notas();
		nota.setId(Integer.valueOf(id));
		nota.setTipo(tipo);
		nota.setConteudo(conteudo);
		nota.setDateTime();
		nota.setDataAtualizada(nota.getDateTime());
		dao.alteraNota(nota);
	
		dao.close();
		
		session.setAttribute("usuario", Integer.valueOf(pessoa_id));
		
		return "index";
	}
	
	@RequestMapping(value = "OrdenaNotas")
	public String ordenaNotas(HttpSession session,
			@RequestParam(value = "pessoa_id") String pessoa_id){
		
		session.setAttribute("usuario", Integer.valueOf(pessoa_id));
		
		return "filtrodeatualizacao";

	}
	
	@RequestMapping("/FiltraNotas")
	public String filtraNotas(HttpSession session,
			@RequestParam(value = "pessoa_id") String pessoa_id,
			@RequestParam(value = "palavra_filtrada") String palavra_filtrada) {
		
		session.setAttribute("palavra_filtrada", palavra_filtrada);
		session.setAttribute("usuario", Integer.valueOf(pessoa_id));
		
		return "filtrodepalavras";
	}
	
	@RequestMapping("/ListaNotas")
	public String listaNotas(HttpSession session,
			@RequestParam(value = "pessoa_id") String pessoa_id) {
		
		DAO dao = new DAO();
		List<Notas> notas = dao.getListaNotas(Integer.valueOf(pessoa_id));
		session.setAttribute("listaNotas", notas);
		session.setAttribute("usuario", Integer.valueOf(pessoa_id));

		dao.close();
		
		return "index";
	}
	
	
}
