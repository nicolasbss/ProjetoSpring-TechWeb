 package br.edu.insper.techweb.projeto1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraCredenciais
 */
@WebServlet("/AlteraCredenciais")
public class AlteraCredenciais extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteraCredenciais() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		pessoa.setId(Integer.valueOf(request.getParameter("pessoa_id")));
		dao.alteraPessoa(pessoa);
	
		dao.close();
		// draw JSP
		try {
			request.setAttribute("usuario", Integer.valueOf(request.getParameter("pessoa_id")));
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	
	 protected void service(HttpServletRequest request,	HttpServletResponse response)
				throws ServletException, IOException {
				
					if (request.getMethod().equals("POST")) {
						this.doPost(request, response);
					}
					else {
						request.setAttribute("pessoa_id", Integer.valueOf(request.getParameter("pessoa_id")));
						request.getRequestDispatcher("alteracredenciais.jsp").forward(request, response);
					}
	 }
}		
