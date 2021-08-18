package fr.eni.encheres.bll;


import fr.eni.encheres.bo.SoldItem;
import fr.eni.encheres.dal.dao.DAOFactory;
import fr.eni.encheres.dal.dao.SoldItemDAO;
import fr.eni.encheres.dal.dao.UserDAO;
import fr.eni.encheres.dal.jdbc.UserJdbc;
import fr.eni.encheres.exception.BusinessException;

public class SoldItemEm {

    private static SoldItemDAO soldItemDAO;


    public SoldItemEm() { SoldItemDAO soldItemDAO = DAOFactory.getSoldItemDAO(); }

    public void createSoldItem (SoldItem soldItem) throws BusinessException {
        BusinessException exception = new BusinessException();

        if(exception.hasErreurs())
        {
            soldItemDAO.insert(soldItem);
        }else{
            throw exception;
        }
    }
}
