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

	private static final String INSERT="INSERT INTO UTILISATEURS " +
            "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	@Override
	public void insert(User user) throws BusinessException { 
		
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getNom());
			pstmt.setString(3, user.getPrenom());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getTelephone());
			pstmt.setString(6, user.getRue());
			pstmt.setString(7, user.getCodePostal());
			pstmt.setString(8, user.getVille());
			pstmt.setString(9, user.getMotDePasse());
			pstmt.setInt(10, user.getCredit());
			pstmt.setBoolean(11, user.isAdministrateur());

			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				user.setNoUtilisateur(rs.getInt(1));
			}
			
			
            cnx.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
	
		}	
	}

	  public void update(User user) throws BusinessException  {
		  try(Connection cnx = ConnectionProvider.getConnection())
		  {
	            String UPDATE = "UPDATE UTILISATEURS SET " +
	                    "                        pseudo = ?, " +
	                    "                        nom = ?, " +
	                    "                        prenom = ?, " +
	                    "                        email = ?, " +
	                    "                        telephone = ?, " +
	                    "                        rue = ?, " +
	                    "                        code_postal = ?, " +
	                    "                        ville = ?, " +
	                    "                        mot_de_passe = ?, " +
	                    "                        credit = ?, " +
	                    "                        administrateur = ? " +
	                    "WHERE no_utilisateur = ?;" +
	                    "UPDATE UTILISATEURS_ROLES SET pseudo = ? WHERE no_utilisateur = ?;";
	            PreparedStatement pstmt = cnx.prepareStatement(UPDATE);
	            pstmt.setString(1, user.getPseudo());
				pstmt.setString(2, user.getNom());
				pstmt.setString(3, user.getPrenom());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getTelephone());
				pstmt.setString(6, user.getRue());
				pstmt.setString(7, user.getCodePostal());
				pstmt.setString(8, user.getVille());
				pstmt.setString(9, user.getMotDePasse());
				pstmt.setInt(10, user.getCredit());
				pstmt.setBoolean(11, user.isAdministrateur());
				pstmt.setInt(12, user.getNoUtilisateur());
				pstmt.setString(13, user.getPseudo());
				pstmt.setInt(14, user.getNoUtilisateur());
				
				pstmt.executeUpdate();
				
	            cnx.close();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	         
	        }
	    }
	  
	  
	   public void delete(User user) throws BusinessException {
		   
		   try(Connection cnx = ConnectionProvider.getConnection())
		   
	        {
	            String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?;" +
	                            "DELETE FROM UTILISATEURS_ROLES WHERE pseudo = ?";
	            PreparedStatement stmt = cnx.prepareStatement(DELETE);
	            stmt.setInt(1, user.getNoUtilisateur());
	            stmt.setString(2, user.getPseudo());
	            stmt.executeUpdate();
	            cnx.close();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	         
	        }
	    }

}
