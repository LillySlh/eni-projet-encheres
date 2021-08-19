package fr.eni.encheres.servlet;


import fr.eni.encheres.bll.SoldItemEm;
import fr.eni.encheres.bo.SoldItem;
import fr.eni.encheres.exception.BusinessException;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class addUser
 */
@WebServlet("/servlet/ServletAddSoldItem")
public class ServletAddSoldItem extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddSoldItem() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/form/newSoldItme.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        SoldItem article = new SoldItem();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDeDebut = null;
        Date DateFin = null;
        try {
            dateDeDebut = format.parse(request.getParameter("startAuction"));
            DateFin = format.parse(request.getParameter("endAuction"));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        article.setNomArticle(request.getParameter("article"));
        article.setDescription(request.getParameter("description"));
        article.setDateDebutEncheres(dateDeDebut);
        article.setDateFinEncheres(DateFin);
        article.setPrixInitial(Integer.parseInt(request.getParameter("miseAprix")));
        article.setPrixVente(200);
        article.setNoUtilisateur(1);
        article.setNoCategorie(1);




        SoldItemEm soldItemEm = new SoldItemEm();
        try {
            soldItemEm.createSoldItem(article);
            System.out.println("COucou ça marche");
        } catch (BusinessException e) {
            System.out.println("Pas COucou ça marche pas" + e);

            e.printStackTrace();
        }

        System.out.print(article+" Objet User ");
        doGet(request, response);
    }

}

