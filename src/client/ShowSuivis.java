package client;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SuiviDao;
import entity.Suivi;

/**
 * Servlet implementation class ShowSuivis
 */
@WebServlet("/ShowSuivis")
public class ShowSuivis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB
    @EJB 
    SuiviDao suiviDao;
	
	/**
	 * 
	 */
    public static final String VUE         = "/suivis_details.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSuivis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récuperation de la liste du suivi du colis
		Integer id_colis = Integer.parseInt( request.getParameter("id") );
		List<Suivi> suiviList = suiviDao.getSuiviByColisId(id_colis);

		// Récupération de la session depuis la requête
        HttpSession session = request.getSession();
        session.setAttribute("sessionSuivi", suiviList);
		
		// Affichage de la page details de suivi
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
