/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Player;
import facade.PlayerFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Dani
 */
@WebService(serviceName = "practicaExamenServiceSOAP")
public class practicaExamenServiceSOAP {

    @EJB
    private PlayerFacade playerFacade;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Player entity) {
        playerFacade.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Player entity) {
        playerFacade.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Player entity) {
        playerFacade.remove(entity);
    }
  
    
    // METODOS PARA LOS JUGADORES
    @WebMethod(operationName = "encontrarJugadores")
    public List<Player> encontrarJugadores() {
        return playerFacade.findAll();
    }
    
    @WebMethod(operationName = "encontrarJugadorPorID")
    public Player encontrarJugadorPorID(@WebParam(name = "id") int id) {
        return playerFacade.encontrarPlayerPorID(id).get(0);
    }
    
    @WebMethod(operationName = "encontrarMaximoIDJugador")
    public int encontrarMaximoIDJugador() {
        return playerFacade.encontrarMayorIDPlayer().get(0) + 1;
    }

}
