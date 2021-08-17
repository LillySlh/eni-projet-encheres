package fr.eni.encheres.dal.dao;

import fr.eni.encheres.bo.Auction;
import fr.eni.encheres.exception.BusinessException;

public interface AuctionDAO {
    /**
     * @param auction
     * @throws BusinessException
     * @throws Exception
     */
    public void insert(Auction auction) throws BusinessException;


}
