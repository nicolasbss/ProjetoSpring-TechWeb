package br.edu.insper.techweb.projeto1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriaNotas
 */
@WebServlet("/CriaNotas")
public class CriaNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriaNotas() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
    		throws ServletException, IOException {
    			// draw JSP
    			try {
    				int id = Integer.valueOf(request.getParameter("pessoa_id"));
					request.setAttribute("pessoa_id", id);
    				request.getRequestDispatcher("/crianotas.jsp").include(request, response);
    			} catch (ServletException e) {
    				e.printStackTrace();
       			}
    		}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    			DAO dao = new DAO();
    			Notas nota = new Notas();
    			
    			nota.setTipo(request.getParameter("tipo"));
    			nota.setDateTime();
    			nota.setConteudo(request.getParameter("conteudo"));
    			nota.setPessoa_id(Integer.valueOf(request.getParameter("pessoa_id")));
    			
    			dao.adicionaNota(nota);
    			
    			// draw JSP
				try {
					request.setAttribute("usuario", Integer.valueOf(request.getParameter("pessoa_id")));
					request.getRequestDispatcher("/index.jsp").include(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
    		}
    
    
}
