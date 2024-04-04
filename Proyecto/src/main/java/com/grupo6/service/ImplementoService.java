/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.service;

import com.grupo6.domain.Implemento;
import java.util.List;

/**
 *
 * @author Morgan
 */
public interface ImplementoService {

    public List<Implemento> getImplementos();

    public Implemento getImplemento(Implemento implemento);
    
    public Implemento getImplementoById(Long id);

    public void save(Implemento implemento);

    public void delete(Implemento implemento);
    
    public List<Implemento> buscarPorNombre(String nombre);
}
