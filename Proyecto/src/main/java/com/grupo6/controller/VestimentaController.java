/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.controller;

import com.grupo6.domain.Vestimenta;
import com.grupo6.service.VestimentaService;
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
 * @author Morgan
 */

@Controller
@RequestMapping("/vestimentas")
public class VestimentaController {

    @Autowired
    private VestimentaService vestimentaService;

    @GetMapping//("/index")
    public String inicio(Model model) {
        var vestimentas = vestimentaService.getVestimentas();
        model.addAttribute("vestimentas", vestimentas);
        return "vestimentas";
    }

    @PostMapping("/guardar")
    public String guardarVestimenta(@ModelAttribute Vestimenta vestimenta,
            @RequestParam("nombre") String nombre,
            @RequestParam("talla") String talla,
            @RequestParam("precio") double precio) {
        // Establece el nombre, la descripción y el precio en el objeto Vestimenta
        vestimenta.setNombre(nombre);
        vestimenta.setTalla(talla);
        vestimenta.setPrecio(precio);

        // Guarda el vestimenta en la base de datos
        vestimentaService.save(vestimenta);

        // Redirige a la página principal después de guardar
        return "redirect:/index";
    }

}
