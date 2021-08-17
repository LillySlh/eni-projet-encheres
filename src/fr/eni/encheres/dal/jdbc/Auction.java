package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.User;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.dao.UserDAO;
import fr.eni.encheres.exception.BusinessException;

public class UserJdbc implements UserDAO {

    String INSERT = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";

    @Override
    public void insert(Auction auction) throws BusinessException {

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, auction.getNoUtilisateur());
            stmt.setInt(2, auction.getNoArticle());
            stmt.setObject(3, new Timestamp(auction.getDateEnchere().getTime()));
            stmt.setInt(4, auction.getMontantEnchere());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                user.setNoUtilisateur(rs.getInt(1));
            }

            cnx.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }






}