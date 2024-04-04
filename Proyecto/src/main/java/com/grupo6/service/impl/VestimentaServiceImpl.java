/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.service.impl;

import com.grupo6.dao.VestimentaDao;
import com.grupo6.domain.Vestimenta;
import com.grupo6.service.VestimentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Morgan
 */
@Service
public class VestimentaServiceImpl implements VestimentaService {

    @Autowired
    private VestimentaDao vestimentaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Vestimenta> getVestimentas() {
        return vestimentaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vestimenta getVestimenta(Vestimenta vestimenta) {
        return vestimentaDao.findById(vestimenta.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Vestimenta vestimenta) {
        vestimentaDao.save(vestimenta);
    }

    @Override
    @Transactional
    public void delete(Vestimenta vestimenta) {
        vestimentaDao.delete(vestimenta);
    }
    
    @Override
    public List<Vestimenta> buscarPorNombre(String nombre) {
        return vestimentaDao.findByNombreContaining(nombre);
    }
}
