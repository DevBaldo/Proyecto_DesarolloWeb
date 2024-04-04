/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.dao;

import com.grupo6.domain.Vestimenta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Morgan
 */
public interface VestimentaDao extends JpaRepository<Vestimenta, Long> {
    List<Vestimenta> findByNombreContaining(String nombre);

}