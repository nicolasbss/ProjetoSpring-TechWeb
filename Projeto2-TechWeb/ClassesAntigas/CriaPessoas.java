package br.edu.insper.techweb.projeto1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriaPessoas
 */
@WebServlet("/CriaPessoas")
public class CriaPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriaPessoas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.getRequestDispatcher("/criapessoas.jsp").include(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		Pessoas pessoa = new Pessoas();
		
		pessoa.setLogin(request.getParameter("login"));
		pessoa.setSenha(request.getParameter("senha"));
		
		dao.adicionaPessoa(pessoa);
		
		// draw JSP
		try {
			request.getRequestDispatcher("/login.jsp").include(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
