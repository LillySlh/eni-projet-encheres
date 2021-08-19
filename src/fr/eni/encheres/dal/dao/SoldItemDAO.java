package fr.eni.encheres.dal.dao;

import fr.eni.encheres.bo.SoldItem;
import fr.eni.encheres.exception.BusinessException;

public interface SoldItemDAO {
    /**
     * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
     * @param soldItem
     * @throws BusinessException
     */
    public void insert(SoldItem soldItem) throws BusinessException;

}
