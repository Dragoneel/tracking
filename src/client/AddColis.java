package client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ColisDao;
import entity.Client;
import entity.Colis;

/**
 * Servlet implementation class AddColis
 */
@WebServlet("/AddColis")
public class AddColis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB
    @EJB 
    ColisDao colisDao; 
	
	/**
	 * 
	 */
    public static final String VUE_HOME         = "/addColis.jsp";
    public static final String VUE_Redi         = "/suivis.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddColis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'ajout de colis */
        this.getServletContext().getRequestDispatcher( VUE_HOME ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletOutputStream out = response.getOutputStream();
		// Recupère les données du formulaire		
		Integer poids      = Integer.parseInt(request.getParameter("poids"));
		Integer valeur	   = Integer.parseInt(request.getParameter("valeur"));
		String origine     = request.getParameter("origine");
		String destination = request.getParameter("destination");
		String label 	   = request.getParameter("label");
		
		// Ajout du colis dans la bdd
		Colis colis = new Colis();
		
		colis.setLabel(label);
		colis.setPoids(poids);
		colis.setValeur(valeur);
		colis.setOrigine(origine);
		colis.setDestination(destination);
		
		HttpSession session = request.getSession(true);
		Client client = (Client)session.getAttribute("sessionClient");
		colis.setClient(client);
		
		colisDao.persist(colis);
		
		this.getServletContext().getRequestDispatcher( VUE_Redi ).forward( request, response );;
	}
	
	

}
