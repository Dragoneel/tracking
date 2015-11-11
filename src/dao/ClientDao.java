package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entity.Client;
 
@Stateless
public class ClientDao {
    // Injected database connection:
    @PersistenceContext 
    private EntityManager em;
 
    // Stores a new client
    public void persist(Client client) {
        em.persist(client);
    }
 
    // Retrieves all the client
    public List<Client> getAllClients() {
        TypedQuery<Client> query = em.createQuery(
            "SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }
    
    // Return client according to username and id
    public List<Client> verifyUser(Object username, Object password) {
        return em.createQuery("SELECT c FROM Client c WHERE c.username = :name and c.password = :pass", Client.class)
        		 .setParameter("name", username)
        		 .setParameter("pass", password)
        		 .getResultList();
    }
}