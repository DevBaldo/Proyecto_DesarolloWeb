/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.dao;
import com.grupo6.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author taraz
 */
public interface RolDao extends JpaRepository<Rol, Long> {

}
