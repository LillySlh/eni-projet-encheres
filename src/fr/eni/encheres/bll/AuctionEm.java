package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Auction;
import fr.eni.encheres.dal.dao.AuctionDAO;
import fr.eni.encheres.exception.BusinessException;

public class UserEm {
    private static AuctionDAO dao;

    public void createAuction(Auction auction) throws BusinessException  {
        dao.insert(auction);
    }

    public void updateAuction(Auction auction) throws BusinessException  {
        dao.update(auction);
    }

    public void DeleteAuction(Auction auction) throws BusinessException  {
        dao.delete(auction);

    }



}
