package fr.eni.encheres.bll;

import fr.eni.encheres.bo.User;
import fr.eni.encheres.dal.dao.UserDAO;
import fr.eni.encheres.exception.BusinessException;

public class UserEm {
	private static UserDAO dao;
	
	 public void createUser(User user) throws BusinessException  {
	            dao.insert(user);
	 }
	 
	 public void updateUser(User user) throws BusinessException  {
         dao.update(user);
	 }
	 
	 public void DeleteUser(User user) throws BusinessException  {
         dao.delete(user);

	 }
	 
	 
	 
}
