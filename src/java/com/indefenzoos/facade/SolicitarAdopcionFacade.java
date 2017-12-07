/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indefenzoos.facade;

import com.indefenzoos.entidades.SolicitarAdopcion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DIANA GALAN
 */
@Stateless
public class SolicitarAdopcionFacade extends AbstractFacade<SolicitarAdopcion> implements SolicitarAdopcionFacadeLocal {

    @PersistenceContext(unitName = "PruebaSiemprePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitarAdopcionFacade() {
        super(SolicitarAdopcion.class);
    }
    
}
