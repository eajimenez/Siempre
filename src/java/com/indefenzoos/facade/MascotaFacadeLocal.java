/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.indefenzoos.facade;

import com.indefenzoos.entidades.Mascota;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DIANA GALAN
 */
@Local
public interface MascotaFacadeLocal {

    void create(Mascota mascota);

    void edit(Mascota mascota);

    void remove(Mascota mascota);

    Mascota find(Object id);

    List<Mascota> findAll();

    List<Mascota> findRange(int[] range);

    int count();
    
}
