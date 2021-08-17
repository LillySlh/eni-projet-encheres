package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Auction;
import fr.eni.encheres.dal.dao.AuctionDAO;
import fr.eni.encheres.exception.BusinessException;

public class AuctionEm {
    private static AuctionDAO dao;

    public void createAuction(Auction auction) throws BusinessException  {
        dao.insert(auction);
    }




}
