package br.edu.insper.techweb.projeto1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AtualizaNotas
 */
@WebServlet("/AtualizaNotas")
public class AtualizaNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizaNotas() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    		}
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    			DAO dao = new DAO();
    			Notas nota = new Notas();
    			nota.setId(Integer.valueOf(request.getParameter("id")));
    			nota.setTipo(request.getParameter("tipo"));
    			nota.setConteudo((request.getParameter("conteudo")));
    			nota.setDateTime();
    			nota.setDataAtualizada(nota.getDateTime());
    			dao.alteraNota(nota);
    		
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
					DAO dao = new DAO();
				
					int id = Integer.valueOf(request.getParameter("id"));
					String texto = dao.getNota(id);
					request.setAttribute("idNota", id);
					request.setAttribute("pessoa_id", Integer.valueOf(request.getParameter("pessoa_id")));
					request.getRequestDispatcher("atualizanotas.jsp").forward(request, response);
				}
			}
}













