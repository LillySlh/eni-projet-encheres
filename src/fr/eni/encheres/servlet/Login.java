package fr.eni.encheres.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/servlet/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/form/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String pseudo = request.getParameter("lilly");
		String motDePasse = request.getParameter("123");

		if(LoginDao.validate(pseudo, motDePasse)){
			RequestDispatcher rd=request.getRequestDispatcher("servlet2");
			rd.forward(request,response);
		}
		else{
			out.print("Désolé l'identifiant et/ou le mot de passe est incorrect");
			RequestDispatcher rd=request.getRequestDispatcher("/servlet/Login");
			rd.include(request,response);
		}

		out.close();*/
		RequestDispatcher rd=request.getRequestDispatcher("/servlet/Login");
		rd.include(request,response);
	}

}
