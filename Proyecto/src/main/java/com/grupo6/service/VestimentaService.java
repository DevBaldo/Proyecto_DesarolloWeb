/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.service;

import com.grupo6.domain.Vestimenta;
import java.util.List;

/**
 *
 * @author Morgan
 */
public interface VestimentaService {

    public List<Vestimenta> getVestimentas();

    public Vestimenta getVestimenta(Vestimenta vestimenta);
    
    public Vestimenta getVestimentaById(Long id);

    public void save(Vestimenta vestimenta);

    public void delete(Vestimenta vestimenta);
    
    public List<Vestimenta> buscarPorNombre(String nombre);
}
