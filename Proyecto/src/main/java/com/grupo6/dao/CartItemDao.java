/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.dao;

import com.grupo6.domain.CartItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Morgan
 */
@Repository
public interface CartItemDao extends JpaRepository<CartItem, Long>{
    List<CartItem> findByImplementoId(Long implementoId);

    List<CartItem> findBySuplementoId(Long suplementoId);

    List<CartItem> findByVestimentaId(Long suplementoId);
}
