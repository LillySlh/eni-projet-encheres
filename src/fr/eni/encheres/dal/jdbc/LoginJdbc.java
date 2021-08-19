package fr.eni.encheres.dal.jdbc;

import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.exception.BusinessException;

import java.sql.*;

public class LoginJdbc{
    public static boolean validate(String pseudo,String motDePasse) throws BusinessException {
    boolean status = false;
            try (Connection cnx = ConnectionProvider.getConnection()){

        PreparedStatement ps = cnx.prepareStatement(
                "select * from UTILISATEURS where pseudo=? and mot_de_passe=?");
        ps.setString(1,pseudo);
        ps.setString(2,motDePasse);

        ResultSet rs=ps.executeQuery();
        status = rs.next();

    }catch(SQLException e){System.out.println(e);}

            return status;
}
}
