package fr.eni.encheres.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UserEm;
import fr.eni.encheres.bo.User;
import fr.eni.encheres.exception.BusinessException;


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

		this.getServletContext().getRequestDispatcher("/WEB-INF/form/newUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		User utilisateur = new User();
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setAdministrateur(true);
		utilisateur.setCodePostal(request.getParameter("codePostal"));
		utilisateur.setCredit(16);
		utilisateur.setEmail(request.getParameter("email"));
		utilisateur.setPrenom(request.getParameter("nom"));
		utilisateur.setNom(request.getParameter("prenom"));
		utilisateur.setMotDePasse(request.getParameter("motDePasse"));
		utilisateur.setRue(request.getParameter("rue"));
		utilisateur.setVille(request.getParameter("ville"));
		utilisateur.setTelephone("0240515555");
		utilisateur.setPseudo(request.getParameter("pseudo"));

		UserEm userEm = new UserEm();
		 try {
			userEm.createUser(utilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		System.out.print(utilisateur+" Objet User ");
		doGet(request, response);
	}

}
