/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.service;

import com.grupo6.domain.Suplemento;
import java.util.List;

/**
 *
 * @author Jose
 */
public interface SuplementoService {

    public List<Suplemento> getSuplementos();

    public Suplemento getSuplemento(Suplemento suplemento);

    public Suplemento getSuplementoById(Long id);
     
    public void save(Suplemento suplemento);

    public void delete(Suplemento suplemento);
    
    public List<Suplemento> buscarPorNombre(String nombre);
}
