package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Auction;
import fr.eni.encheres.dal.dao.AuctionDAO;
import fr.eni.encheres.exception.BusinessException;

public class AuctionEm {
    private static AuctionDAO auctionDAO ;

    public void createAuction(Auction auction) throws BusinessException  {
        BusinessException exception = new BusinessException();

        if(!exception.hasErreurs())
        {
            auctionDAO.insert(auction);
        }else{
            throw exception;
        }
    }



}
