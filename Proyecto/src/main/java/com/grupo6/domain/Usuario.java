/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
/**
 *
 * @author taraz
 */
@Data
@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private Long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    @Column (name = "ruta_imagen")
    private String rutaImagen;    
    private boolean activo = true;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    List<Rol> roles;
}
