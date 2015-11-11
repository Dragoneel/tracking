package dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Suivi;
 
@Stateless
public class SuiviDao { 
    // Injected database connection:
    @PersistenceContext 
    private EntityManager em;
 
    // Stores a new client
    public void persist(Suivi suivi) {
        em.persist(suivi);
    }
 
    // Retrieves all the client
    public List<Suivi> getAllColis() {
        TypedQuery<Suivi> query = em.createQuery(
            "SELECT c FROM Suivi c", Suivi.class);
        return query.getResultList();
    }
    
    // Retrieves suivi according to colis id
    public List<Suivi> getSuiviByColisId(Object id_colis) {
    	return em.createQuery("SELECT s FROM Suivi s WHERE s.coli.id = :id_colis", Suivi.class)
       		 .setParameter("id_colis", id_colis)
       		 .getResultList();
    }
    

}