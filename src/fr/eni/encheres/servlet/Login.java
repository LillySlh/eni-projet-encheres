package fr.eni.encheres.servlet;

import fr.eni.encheres.dal.jdbc.LoginJdbc;
import fr.eni.encheres.exception.BusinessException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String pseudo = request.getParameter("pseudo");
		String motDePasse =request.getParameter("motDePasse");

		try {
			if(LoginJdbc.validate(pseudo, motDePasse)){
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Home");
				rd.forward(request,response);
			}
			else{
				out.print("Désolé l'identifiant et/ou le mot de passe est incorrect");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.include(request,response);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		out.close();;
	}

}
