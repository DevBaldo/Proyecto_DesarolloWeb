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
 * @author taraz
 */
@Data
@Entity
@Table(name = "Promociones")
public class Promociones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Descuento")
    private Double descuento;

    @Column(name = "FechaInicio")
    private String fechaInicio;

    @Column(name = "FechaFin")
    private String fechaFin;

    @Column(name = "ImagenURL")
    private String imagenUrl;

    public Promociones() {
    }

    public Promociones(String descripcion, Double descuento, String fechaInicio, String fechaFin, String imagenUrl) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imagenUrl = imagenUrl;
    }
}