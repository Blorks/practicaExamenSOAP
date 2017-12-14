/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Player;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dani
 */
@Stateless
public class PlayerFacade extends AbstractFacade<Player> {

    @PersistenceContext(unitName = "practicaExamenSOAP-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlayerFacade() {
        super(Player.class);
    }
    
    public List<Player> encontrarPlayerPorID(int id) {
        Query q; 
        
        q = em.createQuery("select p from Player p where p.id = :id");
        q.setParameter("id",  id);
        return q.getResultList();
    }
    
    public List<Integer> encontrarMayorIDPlayer() {
        Query q; 
        
        q = em.createQuery("select MAX(p.id) from Player p");
        return q.getResultList();
    }
    
}
