package classes.antigas;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutenticaUsuario
 */
@WebServlet("/AutenticaUsuario")
public class AutenticaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticaUsuario() {
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
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request,	HttpServletResponse response)
			throws ServletException, IOException {
				
				
				DAO dao = new DAO();
				Pessoas pessoa = new Pessoas();
				
				
				pessoa.setLogin(request.getParameter("login"));
				pessoa.setSenha(request.getParameter("senha"));
				
				int id = dao.autenticaUsuario(pessoa);
				if (id == 0) {
					System.out.println("hasduih");
					request.getRequestDispatcher("login.jsp").forward(request, response); 
				} else {
					request.setAttribute("usuario", id);
					request.getRequestDispatcher("index.jsp").forward(request,response);
				}				
	}
	
}
