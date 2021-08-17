package fr.eni.encheres.dal.dao;

import fr.eni.encheres.dal.jdbc.UserJdbc;

public abstract class DAOFactory {

    public static UserDAO getUserDAO()
    {
        return new UserJdbc();
    }
}
