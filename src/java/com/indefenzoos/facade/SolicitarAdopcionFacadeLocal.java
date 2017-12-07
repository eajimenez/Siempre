/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indefenzoos.facade;

import com.indefenzoos.entidades.SolicitarAdopcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DIANA GALAN
 */
@Local
public interface SolicitarAdopcionFacadeLocal {

    void create(SolicitarAdopcion solicitarAdopcion);

    void edit(SolicitarAdopcion solicitarAdopcion);

    void remove(SolicitarAdopcion solicitarAdopcion);

    SolicitarAdopcion find(Object id);

    List<SolicitarAdopcion> findAll();

    List<SolicitarAdopcion> findRange(int[] range);

    int count();
    
}
