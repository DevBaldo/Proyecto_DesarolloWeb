/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.controller;

import com.grupo6.domain.Promociones;
import com.grupo6.service.PromocionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author taraz
 */
@Controller
@RequestMapping("/promociones")
public class PromocionController {

    @Autowired
    private PromocionService promocionService;

    @GetMapping //("/index")
    public String inicio(Model model) {
        var promociones = promocionService.getAllPromociones();
        model.addAttribute("promociones", promociones);
        return "promociones"; 
    }

    @PostMapping("/guardar")
    public String guardarPromocion(@ModelAttribute Promociones promocion,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("descuento") Double descuento,
            @RequestParam("fechaInicio") String fechaInicio,
            @RequestParam("fechaFin") String fechaFin,
            @RequestParam("imagenUrl") String imagenUrl) {
    
    promocion.setDescripcion(descripcion);
    promocion.setDescuento(descuento);
    promocion.setFechaInicio(fechaInicio);
    promocion.setFechaFin(fechaFin);
    promocion.setImagenUrl(imagenUrl);

    
    promocionService.save(promocion);

    
    return "redirect:/promociones";
}
}
