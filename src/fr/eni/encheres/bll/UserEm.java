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
		userDAO= DAOFactory.getUserDAO();
	}
	
	 public void createUser(User user) throws BusinessException  {

		 BusinessException exception = new BusinessException();

		 if(!exception.hasErreurs())
		 {
			 userDAO.insert(user);
		 }

		 if(exception.hasErreurs())
		 {
			 throw exception;
		 }
	 }


}
