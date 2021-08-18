package fr.eni.encheres.dal.jdbc;

import java.sql.*;

import fr.eni.encheres.bo.Auction;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.dao.AuctionDAO;
import fr.eni.encheres.exception.BusinessException;

public class AuctionJdbc implements AuctionDAO {


    @Override
    public void insert(Auction auction) throws BusinessException {

        if(auction==null)
        {
            BusinessException businessException = new BusinessException();
            businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
            throw businessException;
        }
        try (Connection cnx = ConnectionProvider.getConnection())
        {
            String INSERT = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, auction.getNoUtilisateur());
            stmt.setInt(2, auction.getNoArticle());
            stmt.setObject(3, new Timestamp(auction.getDateEnchere().getTime()));
            stmt.setInt(4, auction.getMontantEnchere());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
            {
                auction.setNoUtilisateur(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}