package client;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDao;
import entity.Client;


public class Connexion extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String CHAMP_USERNAME   = "username";
	public static final String CHAMP_PASS  	    = "motdepasse";
	public static final String ATT_USER         = "Client";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionClient";
    public static final String VUE              = "/login.jsp";
    public static final String VUE_NEXT         = "/addColis.jsp";
    
    
    // Injected DAO EJB
    @EJB 
    ClientDao clientDao; 

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /* Traitement de la requête et récupération du bean en résultant */
        Client Client = null;
        
        List<Client> clientExist = clientDao.verifyUser( getValeurChamp(request,CHAMP_USERNAME), getValeurChamp(request,CHAMP_PASS) );
        
        if ( !clientExist.isEmpty() ) {
        	Client = clientExist.get(0);
		}

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();


        session.setAttribute( ATT_SESSION_USER, Client );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_USER, Client );

        this.getServletContext().getRequestDispatcher( VUE_NEXT ).forward( request, response );
    }
    
    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}