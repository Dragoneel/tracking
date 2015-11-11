package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Colis;
 
@Stateless
public class ColisDao { 
    // Injected database connection
    @PersistenceContext 
    private EntityManager em;
 
    // Stores a new client
    public void persist(Colis colis) {
        em.persist(colis);
    }
 
    // Retrieves all the client
    public List<Colis> getAllColis() {
        TypedQuery<Colis> query = em.createQuery(
            "SELECT c FROM Colis c", Colis.class);
        return query.getResultList();
    }
    
    // Retrieves colis according to client
    public List<Colis> getColisByClientId(Object id_client) {
    	return em.createQuery("SELECT c FROM Colis c WHERE c.client.id = :id_client", Colis.class)
       		 .setParameter("id_client", id_client)
       		 .getResultList();
    }
    
    // Retrieves colis according to client
    public Colis getColisById(Object id_colis) {
    	return em.createQuery("SELECT c FROM Colis c WHERE c.id = :id_colis", Colis.class)
       		 .setParameter("id_colis", id_colis)
       		 .getResultList().get(0);
    }
    

}