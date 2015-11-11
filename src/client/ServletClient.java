package client;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDao;


/**
 * Servlet implementation class ServletClient
 */
public class ServletClient extends HttpServlet {
	  
	  private static final long serialVersionUID = 1L;
       	
	  // Injected DAO EJB:
      @EJB
      ClientDao clientDao;
	  
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	         throws ServletException, IOException {
	    ServletOutputStream out = resp.getOutputStream();
	    out.println("<html><h2>Client list</h2> <table>"+clientDao.verifyUser("ahmed","blabla"));
//	    for (Object client : clientDao.getAllClients()) {
//	      out.print("<tr><td>" + ((Client)client).getNom() + "</tr></td>");
//	    }
	    out.println("</table></html>");
	  }

}
