/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.service.impl;

import com.grupo6.dao.SuplementoDao;
import com.grupo6.domain.Suplemento;
import com.grupo6.service.SuplementoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jose
 */
@Service
public class SuplementoServiceImpl implements SuplementoService {

    @Autowired
    private SuplementoDao suplementoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Suplemento> getSuplementos() {
        return suplementoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Suplemento getSuplemento(Suplemento suplemento) {
        return suplementoDao.findById(suplemento.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Suplemento suplemento) {
        suplementoDao.save(suplemento);
    }

    @Override
    @Transactional
    public void delete(Suplemento suplemento) {
        suplementoDao.delete(suplemento);
    }
    
    @Override
    public List<Suplemento> buscarPorNombre(String nombre) {
        return suplementoDao.findByNombreContaining(nombre);
    }
}

