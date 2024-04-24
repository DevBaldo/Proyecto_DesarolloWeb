/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo6.service;
import jakarta.mail.MessagingException;
/**
 *
 * @author taraz
 */
public interface CorreoService {
    
    public void EnviarCorreoHTML(
        String para, 
        String asunto, 
        String contenidoHTML)
        throws MessagingException;
}
