/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.dao;

import com.grupo6.domain.Suplemento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jose
 */
public interface SuplementoDao extends JpaRepository<Suplemento, Long> {
    List<Suplemento> findByNombreContaining(String nombre);

}
