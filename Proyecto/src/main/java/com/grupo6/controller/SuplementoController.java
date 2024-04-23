/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.controller;

import com.grupo6.domain.Review;
import com.grupo6.domain.Suplemento;
import com.grupo6.service.ReviewService;
import com.grupo6.service.SuplementoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Jose
 */
@Controller
@RequestMapping("/suplementos")
public class SuplementoController {

    @Autowired
    private SuplementoService suplementoService;
    
    @Autowired
    private ReviewService reviewService;

    @GetMapping//("/index")
    public String inicio(Model model) {
        var suplementos = suplementoService.getSuplementos();
        model.addAttribute("suplementos", suplementos);
        return "suplementos";
    }

    @PostMapping("/guardar")
    public String guardarSuplemento(@ModelAttribute Suplemento suplemento,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") double precio,
            @RequestParam("imagenUrl") String imagenUrl) {
        // Establece el nombre, la descripción y el precio en el objeto Implemento
        suplemento.setNombre(nombre);
        suplemento.setDescripcion(descripcion);
        suplemento.setPrecio(precio);
        suplemento.setImagenUrl(imagenUrl);  
        

        // Guarda el implemento en la base de datos
        suplementoService.save(suplemento);

        // Redirige a la página principal después de guardar
        return "redirect:/suplementos";
    }
    
    @GetMapping("/buscar")
    public String buscar(@RequestParam("q") String query, Model model) {
        List<Suplemento> suplementos = suplementoService.buscarPorNombre(query);
        model.addAttribute("suplementos", suplementos);
        return "suplementos";
    }
    
     @GetMapping("/{id}")
    public String suplementoDetails(@PathVariable("id") Long id, Model model) {
        Suplemento suplemento = suplementoService.getSuplementoById(id);
        model.addAttribute("suplemento", suplemento);
        return "suplemento_detail";
    }
}
