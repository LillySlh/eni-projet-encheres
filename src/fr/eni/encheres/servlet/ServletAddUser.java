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
		int noUtilisateur;
		String pseudo;
		String nom;
		String prenom;
		String email;
		String telephone;
		String rue;
		String codePostal;
		String ville;
		String motDePasse;
		int credit;
		boolean administrateur;

		try
		{
			noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));
			pseudo = request.getParameter("pseudo");
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			email = request.getParameter("email");
			telephone = request.getParameter("telephone");
			rue = request.getParameter("rue");
			codePostal = request.getParameter("codePostal");
			ville = request.getParameter("ville");
			motDePasse = request.getParameter("motDePasse");
			credit = (0);
			administrateur = (true);

			UserEm userEm = new UserEm();
			User user = userEm.createUser(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
			request.setAttribute("user", user);
		}
		catch(NumberFormatException e)
		{
			/*List<Integer> listeCodesErreur = new ArrayList<>();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_AVIS_NOTE_ERREUR);
			request.setAttribute("listeCodesErreur",listeCodesErreur);*/
		}  catch (BusinessException e) {
			/*request.setAttribute("listeCodesErreur", e.getListeCodesErreur());*/
		}

		RequestDispatcher rd = request.getRequestDispatcher("/servlet/Home");
		rd.forward(request, response);
	}

}
