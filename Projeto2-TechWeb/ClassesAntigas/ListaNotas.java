package br.edu.insper.techweb.projeto1;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaNotas
 */
@WebServlet("/ListaNotas")
public class ListaNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaNotas() {
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
		// TODO Auto-generated method stubs		
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request,	HttpServletResponse response)
			throws ServletException, IOException {
		
				DAO dao = new DAO();
				List<Notas> notas = dao.getListaNotas(Integer.valueOf(request.getParameter("pessoa_id")));
				request.setAttribute("listaNotas", notas);
				request.setAttribute("usuario", Integer.valueOf(request.getParameter("pessoa_id")));
				request.getRequestDispatcher("index.jsp").forward(request, response); 

				dao.close();
			}
}
