package fr.eni.encheres.dal.dao;


import fr.eni.encheres.bo.User;
import fr.eni.encheres.exception.BusinessException;

public interface UserDAO {
	/**
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param user
	 * @throws BusinessException
	 */
	public void insert(User user) throws BusinessException;
	public void update(User user) throws BusinessException;
	public boolean checkIsValid(String pseudo, String mail) throws BusinessException;
	public boolean checkPseudoValidity(String pseudo) throws BusinessException;
	public boolean checkMailValidity(String mail) throws BusinessException;
}
