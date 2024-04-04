/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.dao;
import com.grupo6.domain.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taraz
 */
@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {
    List<Review> findByImplementoId(Long implementoId);
    
    List<Review> findBySuplementoId(Long suplementoId);
    
    List<Review> findByVestimentaId(Long suplementoId);
}
