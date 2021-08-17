package fr.eni.encheres.dal.dao;


import fr.eni.encheres.bo.User;
import fr.eni.encheres.exception.BusinessException;

public interface UserDAO {
	/**
	 * @param user
	 * @throws BusinessException
	 * @throws Exception 
	 */
	public void insert(User user) throws BusinessException;
	public void update(User user) throws BusinessException;
	public void delete(User user) throws BusinessException;

}
