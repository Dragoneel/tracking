package client;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ColisDao;
import dao.SuiviDao;
import entity.Colis;
import entity.Suivi;

/**
 * Servlet implementation class AddSuivis
 */
@WebServlet("/AddSuivis")
public class AddSuivis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB
    @EJB 
    SuiviDao suiviDao; 
    
    @EJB 
    ColisDao colisDao; 
	
	public static final String VUE         		= "/addSuivis.jsp";
	public static final String NEXT_VUE         = "/suivis.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSuivis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletOutputStream out = response.getOutputStream();
		// Recupère les données du formulaire		
		BigDecimal latitude    = new BigDecimal( Integer.parseInt(request.getParameter("latitude")) );
		BigDecimal longitude   = new BigDecimal( Integer.parseInt(request.getParameter("longitude")) );
		String emplacement     = request.getParameter("emplacement");
		String etat 		   = request.getParameter("etat");
		Integer id_colis	   = Integer.parseInt( request.getParameter("colis") );
		
		// Ajout du colis dans la bdd
		Suivi suivi = new Suivi();
		
		suivi.setLatitude(latitude);
		suivi.setLongitude(longitude);
		suivi.setEmplacement(emplacement);
		suivi.setEtat(etat);
		
		// Ajout l'object colis a suivi
		Colis colis = (Colis) colisDao.getColisById(id_colis);
		suivi.setColi(colis);
		
		// Ajout dans la bdd
		suiviDao.persist(suivi);
		
		this.getServletContext().getRequestDispatcher( NEXT_VUE ).forward( request, response );
	}

}
