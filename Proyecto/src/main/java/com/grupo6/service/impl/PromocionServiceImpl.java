/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.service.impl;
import com.grupo6.dao.PromocionDao;
import com.grupo6.domain.Promociones;
import com.grupo6.service.PromocionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author taraz
 */
@Service
public class PromocionServiceImpl implements PromocionService {

    @Autowired
    private PromocionDao promocionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Promociones> getAllPromociones() {
        return promocionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Promociones getPromocion(Promociones promocion) {
        return promocionDao.findById(promocion.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Promociones promocion) {
        promocionDao.save(promocion);
    }

    @Override
    @Transactional
    public void delete(Promociones promocion) {
        promocionDao.delete(promocion);
    }
}