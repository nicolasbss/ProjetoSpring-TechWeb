package br.edu.insper.techweb.projeto1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveNota
 */
@WebServlet("/RemoveNota")
public class RemoveNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
	}
	
	
	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
				DAO dao = new DAO();
				dao.removeNota(Integer.valueOf(request.getParameter("id")));
				dao.close();
				try {
					request.setAttribute("usuario", Integer.valueOf(request.getParameter("pessoa_id")));
					request.getRequestDispatcher("/index.jsp").include(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
	 }
}
