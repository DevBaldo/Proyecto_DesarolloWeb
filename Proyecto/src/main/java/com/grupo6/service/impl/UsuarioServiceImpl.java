/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.service.impl;

import com.grupo6.dao.RolDao;
import com.grupo6.dao.UsuarioDao;
import com.grupo6.domain.Rol;
import com.grupo6.domain.Usuario;
import com.grupo6.service.UsuarioService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author taraz
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private RolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.existsByUsernameOrCorreo(username, correo);
    }

    @Override
    @Transactional
    public void save(Usuario usuario, boolean crearRolUser) {
        if (crearRolUser) {  //Si se está creando el usuario, se crean los roles por defecto
            Rol rolUser = new Rol();
            rolUser.setNombre("ROLE_USER");
            rolUser.setUsuario(usuario);
            if (usuario.getRoles() == null) {
                usuario.setRoles(new ArrayList<>());
            }
            usuario.getRoles().add(rolUser);

            Rol rolAdmin = new Rol();
            rolAdmin.setNombre("ROLE_ADMIN");
            rolAdmin.setUsuario(usuario);
            if (usuario.getRoles() == null) {
                usuario.setRoles(new ArrayList<>());
            }
            usuario.getRoles().add(rolAdmin);

            Rol rolVendedor = new Rol();
            rolVendedor.setNombre("ROLE_VENDEDOR");
            rolVendedor.setUsuario(usuario);
            if (usuario.getRoles() == null) {
                usuario.setRoles(new ArrayList<>());
            }
            usuario.getRoles().add(rolVendedor);
        }
        usuario = usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
}
