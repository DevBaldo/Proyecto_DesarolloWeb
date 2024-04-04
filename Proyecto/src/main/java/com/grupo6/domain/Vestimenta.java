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
 * @author Morgan
 */
@Data
@Entity
@Table(name = "Vestimenta")

public class Vestimenta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Talla")
    private String talla;

    @Column(name = "Precio")
    private double precio;
    
    @Column(name = "ImagenURL")
    private String imagenUrl;
    
    @OneToMany(mappedBy = "vestimenta")
    private List<Review> reviews;
    
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    
    public Vestimenta() {
    }

    public Vestimenta(String nombre, String talla, double precio, String imagenUrl) {
        this.nombre = nombre;
        this.talla = talla;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
    }
}
