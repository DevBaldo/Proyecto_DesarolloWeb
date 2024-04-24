/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.service.impl;
import com.grupo6.service.CorreoService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
/**
 *
 * @author taraz
 */
@Service
public class CorreoServiceImpl implements CorreoService{

    @Autowired
    private JavaMailSender mailSender;
    
    @Override
    public void EnviarCorreoHTML(String para, String asunto, String contenidoHTML) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper
                = new MimeMessageHelper(message,
                        true);
        helper.setTo(para);
        helper.setSubject(asunto);
        helper.setText(contenidoHTML, true);
        mailSender.send(message);
    }

}
