package fr.eni.encheres.bll;


import fr.eni.encheres.bo.SoldItem;
import fr.eni.encheres.dal.dao.DAOFactory;
import fr.eni.encheres.dal.dao.SoldItemDAO;
import fr.eni.encheres.exception.BusinessException;
/**
 * Cette classe permet d'effectuer les traitements attendus sur la classe SoldItem
 */

public class SoldItemEm {

    private static SoldItemDAO soldItemDAO;

    /**
     * Le constructeur permet d'initialiser la variable membre soldItemDAO pour
     * permettre une communication avec la base de données.
     */
    public SoldItemEm() { soldItemDAO = DAOFactory.getSoldItemDAO(); }

    public void createSoldItem (SoldItem soldItem) throws BusinessException {

        BusinessException exception = new BusinessException();

        if(exception.hasErreurs())
        {
            System.out.println("Je passe bien dans le Em");
            soldItemDAO.insertSoldItem(soldItem);
        }
        if(exception.hasErreurs())
        {
            throw exception;
        }
    }
}
