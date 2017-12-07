/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indefenzoos.facade;

import com.indefenzoos.entidades.DarAdopcion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DIANA GALAN
 */
@Local
public interface DarAdopcionFacadeLocal {

    void create(DarAdopcion darAdopcion);

    void edit(DarAdopcion darAdopcion);

    void remove(DarAdopcion darAdopcion);

    DarAdopcion find(Object id);

    List<DarAdopcion> findAll();

    List<DarAdopcion> findRange(int[] range);

    int count();
    
}
