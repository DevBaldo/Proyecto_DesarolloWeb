/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.service;
import com.grupo6.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author taraz
 */
public interface RegistroService {
 
    public Model activar(Model model, String usuario, String clave);
 
    Model crearUsuario(Model model, Usuario usuario, String password) throws MessagingException;
    public void activar(Usuario usuario, MultipartFile imagenFile);
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException;
}