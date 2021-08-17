package fr.eni.encheres.dal.dao;

import fr.eni.encheres.bo.Auction;
import fr.eni.encheres.exception.BusinessException;

public interface UserDAO {
    /**
     * @param user
     * @throws BusinessException
     * @throws Exception
     */
    public void insert(Auction auction) throws BusinessException;
    public void update(Auction auction) throws BusinessException;
    public void delete(Auction auction) throws BusinessException;

}
