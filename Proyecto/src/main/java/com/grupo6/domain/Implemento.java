/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo6.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
/**
 *
 * @author Morgan
 */
@Data
@Entity
@Table(name = "Implementos")

public class Implemento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Precio")
    private double precio;
    
    @Column(name = "ImagenURL")
    private String imagenUrl;
    
    public Implemento() {
    }

    public Implemento(String nombre, String descripcion, double precio, String imagenUrl) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
    }
}
