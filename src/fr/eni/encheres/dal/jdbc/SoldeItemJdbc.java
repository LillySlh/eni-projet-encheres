package fr.eni.encheres.dal.jdbc;

import fr.eni.encheres.bo.SoldItem;

import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.dao.SoldItemDAO;
import fr.eni.encheres.exception.BusinessException;

import java.sql.*;

public class SoldeItemJdbc implements SoldItemDAO {
    @Override
    public void insert(SoldItem soldItem) throws BusinessException {

        if (soldItem == null) {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }
        try(Connection cnx = ConnectionProvider.getConnection())
    {
            String INSERT = "INSERT INTO ARTICLES_VENDUS " +
                    "(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, soldItem.getNomArticle());
        pstmt.setString(2, soldItem.getDescription());
        pstmt.setObject(3,new Timestamp(soldItem.getDateDebutEncheres().getTime() ) );
        pstmt.setObject(4,new Timestamp(soldItem.getDateFinEncheres().getTime() ) );
        pstmt.setInt(5, soldItem.getPrixInitial());
        pstmt.setInt(6, soldItem.getPrixVente());
        pstmt.setString(7, soldItem.getEtatVente());
        pstmt.setInt(8, soldItem.getNoUtilisateur());
        pstmt.setInt(9, soldItem.getNoCategorie());


        pstmt.executeUpdate();
        ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                soldItem.setNoArticle(rs.getInt(1));
            }

        } catch (SQLException e) {

            System.out.print("NOpe" +" "+ e);
            e.printStackTrace();

        }
    }

}
