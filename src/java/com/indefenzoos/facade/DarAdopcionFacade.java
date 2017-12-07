/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indefenzoos.facade;

import com.indefenzoos.entidades.DarAdopcion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DIANA GALAN
 */
@Stateless
public class DarAdopcionFacade extends AbstractFacade<DarAdopcion> implements DarAdopcionFacadeLocal {

    @PersistenceContext(unitName = "PruebaSiemprePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DarAdopcionFacade() {
        super(DarAdopcion.class);
    }
    
}
