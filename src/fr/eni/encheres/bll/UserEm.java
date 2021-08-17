package fr.eni.encheres.bll;

import fr.eni.encheres.bo.User;
import fr.eni.encheres.dal.dao.DAOFactory;
import fr.eni.encheres.dal.dao.UserDAO;
import fr.eni.encheres.exception.BusinessException;

/**
 *
 *
 * Cette classe permet d'effectuer les traitements attendus sur la classe User
 */

public class UserEm {

	private static UserDAO userDAO;

	/**
	 * Le constructeur permet d'initialiser la variable membre dao pour
	 * permettre une communication avec la base de données.
	 */

	public UserEm() {
		this.userDAO= DAOFactory.getUserDAO();
	}
	
	 public User createUser(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws BusinessException
	 {

		 BusinessException exception = new BusinessException();

		 User user = new User(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);

		 if(!exception.hasErreurs())
		 {
			 this.userDAO.insert(user);
		 }

		 if(exception.hasErreurs())
		 {
			 throw exception;
		 }
		 return user;
	 }


}
