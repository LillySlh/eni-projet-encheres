package fr.eni.encheres.dal.dao;

import fr.eni.encheres.bo.SoldItem;
import fr.eni.encheres.exception.BusinessException;

public interface SoldItemDAO {
    /**
     * En cas d'erreur, le code d'erreur est enregistrĂ© dans l'objet businessException.
     * @param soldItem
     * @throws BusinessException
     */
    public void insertSoldItem(SoldItem soldItem) throws BusinessException;

}
