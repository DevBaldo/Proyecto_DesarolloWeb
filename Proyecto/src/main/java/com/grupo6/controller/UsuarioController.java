/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.controller;
import com.grupo6.domain.Usuario;
import com.grupo6.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author taraz
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String listado(Model model, Principal principal) {
        String loggedInUsername = principal.getName();

        Usuario usuario = usuarioService.getUsuarioByUsername(loggedInUsername);

        model.addAttribute("usuario", usuario);

        return "/usuario/listado";
    }


    @GetMapping("/nuevo")
    public String usuarioNuevo(Usuario usuario) {
        return "/usuario/modifica";
    }

    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario,
            @RequestParam(value = "imagenFile", required = false) MultipartFile imagenFile) {
        if (imagenFile != null && !imagenFile.isEmpty()) {
        try {
            
            String fileName = StringUtils.cleanPath(imagenFile.getOriginalFilename());
            String uploadDir = "C:\\dev\\Proyecto_v1\\Proyecto_DesarolloWeb";
            java.nio.file.Path uploadPath = Paths.get(uploadDir);
            
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = imagenFile.getInputStream()) {
                java.nio.file.Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
                usuario.setRutaImagen("/Proyecto_DesarolloWeb/" + fileName); 
            } catch (IOException e) {
                
            }
        } catch (Exception e) {
            
        }
    }
    usuarioService.save(usuario, true);
    return "redirect:/usuario/listado";
}

    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario, HttpSession session) {
        usuarioService.delete(usuario);
        session.invalidate();  // Cierra la sesión
        return "redirect:/";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/modifica";
    }
}