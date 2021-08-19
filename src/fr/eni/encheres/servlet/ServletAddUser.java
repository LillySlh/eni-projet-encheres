package fr.eni.encheres.servlet;


import fr.eni.encheres.bll.UserEm;
import fr.eni.encheres.bo.User;
import fr.eni.encheres.exception.BusinessException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class addUser
 */
@WebServlet("/servlet/ServletAddUser")
public class ServletAddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/form/newUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		User utilisateur = new User();
		utilisateur.setPseudo(request.getParameter("pseudo"));
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setEmail(request.getParameter("email"));
		utilisateur.setTelephone("telephone");
		utilisateur.setRue(request.getParameter("rue"));
		utilisateur.setCodePostal(request.getParameter("codePostal"));
		utilisateur.setVille(request.getParameter("ville"));
		utilisateur.setMotDePasse(request.getParameter("motDePasse"));
		utilisateur.setCredit(16);
		utilisateur.setAdministrateur(true);

		UserEm userEm = new UserEm();
		 try {
			userEm.createUser(utilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		System.out.print(utilisateur+" Objet User ");
		RequestDispatcher rd = request.getRequestDispatcher("/servlet/Home");
		rd.forward(request, response);
	}

}
