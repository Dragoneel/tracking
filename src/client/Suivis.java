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

/**
 * Servlet implementation class Suivis
 */
@WebServlet("/Suivis")
public class Suivis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB
    @EJB 
    ColisDao colisDao;
    
    /**
	 * 
	 */
    public static final String VUE         = "/suivis.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suivis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("sessionClient");
        Integer id_client = client.getId();
        
        session.setAttribute( "sessionColis", colisDao.getColisByClientId(id_client) );
        
        /* Affichage de la page de suivis */
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
