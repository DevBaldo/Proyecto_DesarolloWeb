/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.service;
import com.grupo6.domain.Promociones;
import java.util.List;
/**
 *
 * @author taraz
 */
public interface PromocionService {

    List<Promociones> getAllPromociones();
    
    public Promociones getPromocion(Promociones promocion);

    void save(Promociones promocion);

    public void delete(Promociones promocion);
    
    public List<Promociones> buscarPorDescripcion(String descripcion);
}
