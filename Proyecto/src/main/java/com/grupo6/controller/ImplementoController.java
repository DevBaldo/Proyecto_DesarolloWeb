/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.controller;

import com.grupo6.domain.Implemento;
import com.grupo6.service.ImplementoService;
import com.grupo6.domain.Review;
import com.grupo6.service.ReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Morgan
 */

@Controller
@RequestMapping("/implementos")
public class ImplementoController {

    @Autowired
    private ImplementoService implementoService;
    @Autowired
    private ReviewService reviewService;
    
    

    @GetMapping//("/index")
    public String inicio(Model model) {
        var implementos = implementoService.getImplementos();
        model.addAttribute("implementos", implementos);
        return "implementos";
    }

    @PostMapping("/guardar")
    public String guardarImplemento(@ModelAttribute Implemento implemento,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") double precio) {
        // Establece el nombre, la descripción y el precio en el objeto Implemento
        implemento.setNombre(nombre);
        implemento.setDescripcion(descripcion);
        implemento.setPrecio(precio);

        // Guarda el implemento en la base de datos
        implementoService.save(implemento);

        // Redirige a la página principal después de guardar
        return "redirect:/index";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam("q") String query, Model model) {
        List<Implemento> implementos = implementoService.buscarPorNombre(query);
        model.addAttribute("implementos", implementos);
        return "implementos";
    }

    @GetMapping("/{id}")
    public String implementoDetails(@PathVariable("id") Long id, Model model) {
        Implemento implemento = implementoService.getImplementoById(id);
        model.addAttribute("implemento", implemento);
        return "implemento_detail";
    }

    @PostMapping("/{implementoId}/reviews")
    public String addReview(@PathVariable("implementoId") Long implementoId,
            @ModelAttribute Review review) {
        Implemento implemento = implementoService.getImplementoById(implementoId);
        review.setImplemento(implemento);
        reviewService.saveReview(review);
        return "redirect:/implementos/{implementoId}";
    }
}
