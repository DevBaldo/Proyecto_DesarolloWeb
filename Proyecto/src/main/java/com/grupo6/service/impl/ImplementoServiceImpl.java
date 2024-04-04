/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.service.impl;

import com.grupo6.dao.ImplementoDao;
import com.grupo6.domain.Implemento;
import com.grupo6.service.ImplementoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Morgan
 */
@Service
public class ImplementoServiceImpl implements ImplementoService {

    @Autowired
    private ImplementoDao implementoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Implemento> getImplementos() {
        return implementoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Implemento getImplemento(Implemento implemento) {
        return implementoDao.findById(implemento.getId()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Implemento getImplementoById(Long id) {
        return implementoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Implemento implemento) {
        implementoDao.save(implemento);
    }

    @Override
    @Transactional
    public void delete(Implemento implemento) {
        implementoDao.delete(implemento);
    }
    
    @Override
    public List<Implemento> buscarPorNombre(String nombre) {
        return implementoDao.findByNombreContaining(nombre);
    }
}
